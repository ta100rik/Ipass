package web;

import com.google.gson.Gson;
import domain.Deal;
import service.CustomerServiceProvider;
import service.DealServiceProvider;
import service.ServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/Deal")
public class DealController {
    private DealServiceProvider CSP = ServiceProvider.getDealServiceProvider();

    @GET
    @Produces("application/json")
    public String getDeal(){
        List<Deal> list = CSP.getDeals();
        Gson gson = new Gson();
        String result = "{";
        int counter = 0;
        final int totalrowcount = list.size();
        for (Deal deal:list) {
            result += "\"" +counter + "\":";
            String json = gson.toJson(deal);
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
}
