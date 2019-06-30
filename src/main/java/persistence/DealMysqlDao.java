package persistence;

import baseDao.MysqlbaseDao;
import domain.Customer;
import domain.Deal;

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
                allDeals.add(new_deal);
            }
            con.close();
            return allDeals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDeals;
    }
}
