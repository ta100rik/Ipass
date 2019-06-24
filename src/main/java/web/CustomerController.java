package web;

import service.CustomerServiceProvider;
import service.ServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Customer")
public class CustomerController {
    private CustomerServiceProvider CSP = ServiceProvider.getCustomerServiceProvider();
    @GET
    @Produces("application/json")
    public String getCustomer(){
        return "Customer";
    }

}
