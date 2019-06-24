package service;

public class ServiceProvider {
    private static CustomerServiceProvider CSP  = new CustomerServiceProvider();
    private static UserServiceProvider USP      = new UserServiceProvider();
    public static CustomerServiceProvider getCustomerServiceProvider(){
        return CSP;
    }
    public static UserServiceProvider getUserServiceProvider(){return USP;}
}
