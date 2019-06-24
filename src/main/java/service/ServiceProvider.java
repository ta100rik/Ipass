package service;

public class ServiceProvider {
    private static CustomerServiceProvider CSP = new CustomerServiceProvider();
    public static CustomerServiceProvider getCustomerServiceProvider(){
        return CSP;
    }
}
