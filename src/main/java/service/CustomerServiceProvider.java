package service;

import domain.Customer;
import domain.Deal;
import persistence.CustomerDao;
import persistence.CustomerMySqlDao;

import java.security.Key;
import java.util.List;
/*
*   here we specify where the customer data comes from
* */
public class CustomerServiceProvider {
    private CustomerDao CD = new CustomerMySqlDao();
    public List<Customer> getCustomers(){
        return CD.getCustomer();
    }


}
