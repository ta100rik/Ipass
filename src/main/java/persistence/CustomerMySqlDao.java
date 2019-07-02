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
//        getting the connection
        Connection con = super.getConnection();
//        making a list to append on later in the code
        List<Customer> allCustomers = new ArrayList<Customer>();

        try {
//create a stetement
            Statement statement = con.createStatement();
//            always make the resultset avaidble
            ResultSet resultSet = null;
//            excute select query on the database
            resultSet = statement.executeQuery("SELECT * FROM customer");
//            loop throught the records
            while (resultSet.next()) {
//                ininilize the variables
                Integer cnumber = resultSet.getInt("customernumber");
                String cname = resultSet.getString("customername");
//                putting all the variables in a object
                Customer new_Customer = new Customer(cnumber,cname);
//              adding the just created object to the list
                allCustomers.add(new_Customer);
            }
//            close the current connection
            con.close();
//            return the array
            return allCustomers;
//            print the array if it goes wrong
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return null as a array
        return allCustomers;
    }
}
