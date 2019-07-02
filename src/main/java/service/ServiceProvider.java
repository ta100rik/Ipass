package service;
/*
*   this is a service provider everything requested will be orginazid here
*   also to be sure if we change from source we only need to change it here and
*   make the new one implements the interface
* */
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
