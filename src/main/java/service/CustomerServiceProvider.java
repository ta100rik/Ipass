package service;

import domain.Customer;
import persistence.CustomerDao;
import persistence.CustomerMySqlDao;

import java.util.List;

public class CustomerServiceProvider {
    private CustomerDao CD = new CustomerMySqlDao();
    public List<Customer> getCustomers(){
        return CD.getCustomer();
    }


}
