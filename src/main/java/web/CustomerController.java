package web;

import com.google.gson.Gson;
import domain.Customer;
import service.CustomerServiceProvider;
import service.ServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Path("/Customer")
public class CustomerController {
    private CustomerServiceProvider CSP = ServiceProvider.getCustomerServiceProvider();
    @GET
    @Produces("application/json")
    public String getCustomer() {
        List<Customer> customers =  CSP.getCustomers();
        Gson gson = new Gson();
        String result = "{";
        int counter = 0;
        final int totalrowcount = customers.size();
        for (Customer customer:customers) {
            result += "\"" +counter + "\":";
            String json = gson.toJson(customer);
            counter++;
            if(counter == totalrowcount){
                result += json ;
            }else{
                result += json + ",";
            }
//            System.out.println(json);
        }
        result = result + "}";
//        System.out.println(result);
        return result;
    }

//    private String ListToJson(List<Object> list){
//        Gson gson = new Gson();
//        String result = "{";
//        int counter = 0;
//        final int totalrowcount = list.size();
//        for (customer:list) {
//            result += "\"" +counter + "\":";
//            String json = gson.toJson(customer);
//            counter++;
//            if(counter == totalrowcount){
//                result += json ;
//            }else{
//                result += json + ",";
//            }
////            System.out.println(json);
//        }
//        result = result + "}";
//        return result;
//    }


}
