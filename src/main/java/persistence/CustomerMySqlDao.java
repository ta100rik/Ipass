package persistence;

import baseDao.MysqlbaseDao;
import domain.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySqlDao extends MysqlbaseDao implements CustomerDao{

    public List<Customer> getCustomer(){
        Connection con = super.getConnection();
        List<Customer> allCustomers = new ArrayList<Customer>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                Integer cnumber = resultSet.getInt("customernumber");
                String cname = resultSet.getString("customername");
                Customer new_Customer = new Customer(cnumber,cname);
                allCustomers.add(new_Customer);
            }
            con.close();
            return allCustomers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }
}
