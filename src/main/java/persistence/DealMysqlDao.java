package persistence;

import baseDao.MysqlbaseDao;
import domain.Customer;
import domain.Deal;
import domain.DealMaterial;
import domain.MaterialLineDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DealMysqlDao extends MysqlbaseDao implements DealDao{

    public List<Deal> getDeals(){
//        getting a connection
        Connection con = super.getConnection();
//        making a list
        List<Deal> allDeals = new ArrayList<Deal>();
        try {
//            preparing a statement
            Statement statement = con.createStatement();
//            default result set to null
            ResultSet resultSet = null;
//            executing query select
            resultSet = statement.executeQuery("SELECT * FROM deal");
//            looping throuhgt every database record
            while (resultSet.next()) {
//                initilizing variables
                Integer id = resultSet.getInt("idDeal");
                String dealname = resultSet.getString("dealname");
                String one_time_benefit = resultSet.getString("one_time_benefit");
//                assing it to a top level deal
                Deal new_deal = new Deal(id,dealname,one_time_benefit);
//                preparing second detail statement
                Statement secondstatement = con.createStatement();
//                running second statement
                ResultSet line2 = secondstatement.executeQuery("SELECT * FROM deal_materials where deal = " + id);
                while(line2.next()){
//                    loop throught the records found of the deal_material
//                    joining not possible because 1 to many
//                    initlizing variables again
                    Integer lineid = line2.getInt("iddeal_materials");
                    String VPN = line2.getString("VPN");
                    Float purchasing_price = line2.getFloat("purchasing_price");
                    Float deal = line2.getFloat("deal");
//                    making a new object of it
                    DealMaterial new_material = new DealMaterial(lineid,VPN,purchasing_price);
//                    preparing line details
                    Statement materialdetailsstatement = con.createStatement();
//                    running query for line details
                    ResultSet materialdetailsstatementresult = materialdetailsstatement.executeQuery("SELECT * FROM dealregister.material_line_detail where foreing_key_material = " + lineid);
//                    loop through the line details
                    while(materialdetailsstatementresult.next()){
//                        initiliaze the variables
                       Integer linedetailid = materialdetailsstatementresult.getInt("Material_detail_id");
                       Integer amount = materialdetailsstatementresult.getInt("amount");
                       String type  = materialdetailsstatementresult.getString("type");
                       String receive_date  = materialdetailsstatementresult.getString("receive_date");
                       String ship_date  = materialdetailsstatementresult.getString("ship_date");
                       String customer  = materialdetailsstatementresult.getString("customer");
                       String reseller_discount  = materialdetailsstatementresult.getString("reseller_discount");
//                      details of object making
                       MaterialLineDetails new_detail = new MaterialLineDetails(linedetailid,amount,type,receive_date,ship_date,customer,reseller_discount);
//                       adding to the current detail line
                       new_material.add_details(new_detail);
                    }
//                    adding the detail line to the record
                    new_deal.addDealMaterial(new_material);
                }
//                adding the record to the global variable
                allDeals.add(new_deal);
            }
            con.close();
//            returning the records deal with all the object nested
            return allDeals;
        } catch (SQLException e) {
//            print error message
            e.printStackTrace();
        }
//        return array of null other wise function will cause a syntax error
        return allDeals;
    }
    public Deal getDeal(String id){
//        making connection
        Connection con = super.getConnection();
        Deal new_deal = null;
        try {
//            creating statement
            Statement statement = con.createStatement();
            ResultSet resultSet = null;
//            running the query id is generated by system so that why not prepared statement
            resultSet = statement.executeQuery("SELECT * FROM deal where idDeal = " + id);
//           looping throught the records
            while (resultSet.next()) {
//                init top level deal variables
                Integer ids = resultSet.getInt("idDeal");
                String dealname = resultSet.getString("dealname");
                String one_time_benefit = resultSet.getString("one_time_benefit");
//                make the deal object
                Deal new_deals = new Deal(ids,dealname,one_time_benefit);
                Statement secondstatement = con.createStatement();
//                run query for detail second level
                ResultSet line2 = secondstatement.executeQuery("SELECT * FROM deal_materials where deal = " + id);
                while(line2.next()){
//                    initilize second level details
                    Integer lineid = line2.getInt("iddeal_materials");
                    String VPN = line2.getString("VPN");
                    Float purchasing_price = line2.getFloat("purchasing_price");
                    Float deal = line2.getFloat("deal");
//                    make a object of the second line
                    DealMaterial new_material = new DealMaterial(lineid,VPN,purchasing_price);
//                    get thirth level details
                    Statement materialdetailsstatement = con.createStatement();
//                    run query
                    ResultSet materialdetailsstatementresult = materialdetailsstatement.executeQuery("SELECT * FROM dealregister.material_line_detail where foreing_key_material = " + lineid);
                    while(materialdetailsstatementresult.next()){
//                        initilize third level attributes
                        Integer linedetailid = materialdetailsstatementresult.getInt("Material_detail_id");
                        Integer amount = materialdetailsstatementresult.getInt("amount");
                        String type  = materialdetailsstatementresult.getString("type");
                        String receive_date  = materialdetailsstatementresult.getString("receive_date");
                        String ship_date  = materialdetailsstatementresult.getString("ship_date");
                        String customer  = materialdetailsstatementresult.getString("customer");
                        String reseller_discount  = materialdetailsstatementresult.getString("reseller_discount");
//                        assing it at a third line attribute
                        MaterialLineDetails new_detail = new MaterialLineDetails(linedetailid,amount,type,receive_date,ship_date,customer,reseller_discount);
//                        add this line to the second level
                        new_material.add_details(new_detail);
                    }
//                    add the second level to the first line
                    new_deals.addDealMaterial(new_material);
                }
//                return the deal
                return new_deals;
            }
            con.close();
            return new_deal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new_deal;
    }


}
