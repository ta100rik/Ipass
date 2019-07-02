package web;

import com.google.gson.Gson;
import domain.Customer;
import service.CustomerServiceProvider;
import service.ServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
/*
* everything in here will be for customer and all the http request will be cought here of the path named customer
* */

@Path("/Customer")
public class CustomerController {
    private CustomerServiceProvider CSP = ServiceProvider.getCustomerServiceProvider();
    @GET
    @Produces("application/json")
    public String getCustomer() {
        List<Customer> customers =  CSP.getCustomers();
//        gson is a libary to convert object to json
        Gson gson = new Gson();
//        making a result string a array of mulitple object in to 1 big string
        String result = "{";
        int counter = 0;
        final int totalrowcount = customers.size();
        for (Customer customer:customers) {
//            looping throught the array and convirting it in to a string
            result += "\"" +counter + "\":";
            String json = gson.toJson(customer);
            counter++;
            if(counter == totalrowcount){
                result += json ;
            }else{
                result += json + ",";
            }
        }
        result = result + "}";
//        if it is done return the just generated array
        return result;
    }

}
