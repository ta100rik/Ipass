package service;

public class ServiceProvider {
    private static CustomerServiceProvider CSP  = new CustomerServiceProvider();
    private static UserServiceProvider USP      = new UserServiceProvider();
    private static DealServiceProvider DSP      = new DealServiceProvider();
    public static CustomerServiceProvider getCustomerServiceProvider(){
        return CSP;
    }
    public static UserServiceProvider getUserServiceProvider(){return USP;}
    public static DealServiceProvider getDealServiceProvider(){return DSP;}

}
