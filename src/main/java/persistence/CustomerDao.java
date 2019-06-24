package persistence;

import domain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomer();
}
