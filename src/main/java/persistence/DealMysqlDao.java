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
        Connection con = super.getConnection();
        List<Deal> allDeals = new ArrayList<Deal>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * FROM deal");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idDeal");
                String dealname = resultSet.getString("dealname");
                String one_time_benefit = resultSet.getString("one_time_benefit");
                Deal new_deal = new Deal(id,dealname,one_time_benefit);
                Statement secondstatement = con.createStatement();
                ResultSet line2 = secondstatement.executeQuery("SELECT * FROM deal_materials where deal = " + id);
                while(line2.next()){
                    Integer lineid = line2.getInt("iddeal_materials");
                    String VPN = line2.getString("VPN");
                    Float purchasing_price = line2.getFloat("purchasing_price");
                    Float deal = line2.getFloat("deal");
                    DealMaterial new_material = new DealMaterial(lineid,VPN,purchasing_price);
                    Statement materialdetailsstatement = con.createStatement();
                    ResultSet materialdetailsstatementresult = materialdetailsstatement.executeQuery("SELECT * FROM dealregister.material_line_detail where foreing_key_material = " + lineid);
                    while(materialdetailsstatementresult.next()){
                       Integer linedetailid = materialdetailsstatementresult.getInt("Material_detail_id");
                       Integer amount = materialdetailsstatementresult.getInt("amount");
                       String type  = materialdetailsstatementresult.getString("type");
                       String receive_date  = materialdetailsstatementresult.getString("receive_date");
                       String ship_date  = materialdetailsstatementresult.getString("ship_date");
                       String customer  = materialdetailsstatementresult.getString("customer");
                       String reseller_discount  = materialdetailsstatementresult.getString("reseller_discount");
                       MaterialLineDetails new_detail = new MaterialLineDetails(linedetailid,amount,type,receive_date,ship_date,customer,reseller_discount);
                       new_material.add_details(new_detail);
                    }
                    new_deal.addDealMaterial(new_material);
                }
                allDeals.add(new_deal);
            }
            con.close();
            return allDeals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDeals;
    }
    public Deal getDeal(String id){
        Connection con = super.getConnection();
        Deal new_deal = null;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * FROM deal where idDeal = " + id);
            while (resultSet.next()) {
                Integer ids = resultSet.getInt("idDeal");
                String dealname = resultSet.getString("dealname");
                String one_time_benefit = resultSet.getString("one_time_benefit");
                Deal new_deals = new Deal(ids,dealname,one_time_benefit);
                Statement secondstatement = con.createStatement();
                ResultSet line2 = secondstatement.executeQuery("SELECT * FROM deal_materials where deal = " + id);
                while(line2.next()){
                    Integer lineid = line2.getInt("iddeal_materials");
                    String VPN = line2.getString("VPN");
                    Float purchasing_price = line2.getFloat("purchasing_price");
                    Float deal = line2.getFloat("deal");
                    DealMaterial new_material = new DealMaterial(lineid,VPN,purchasing_price);
                    Statement materialdetailsstatement = con.createStatement();
                    ResultSet materialdetailsstatementresult = materialdetailsstatement.executeQuery("SELECT * FROM dealregister.material_line_detail where foreing_key_material = " + lineid);
                    while(materialdetailsstatementresult.next()){
                        Integer linedetailid = materialdetailsstatementresult.getInt("Material_detail_id");
                        Integer amount = materialdetailsstatementresult.getInt("amount");
                        String type  = materialdetailsstatementresult.getString("type");
                        String receive_date  = materialdetailsstatementresult.getString("receive_date");
                        String ship_date  = materialdetailsstatementresult.getString("ship_date");
                        String customer  = materialdetailsstatementresult.getString("customer");
                        String reseller_discount  = materialdetailsstatementresult.getString("reseller_discount");
                        MaterialLineDetails new_detail = new MaterialLineDetails(linedetailid,amount,type,receive_date,ship_date,customer,reseller_discount);
                        new_material.add_details(new_detail);
                    }
                    new_deals.addDealMaterial(new_material);
                }
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
