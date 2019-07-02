package web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import domain.Deal;
import service.CustomerServiceProvider;
import service.DealServiceProvider;
import service.ServiceProvider;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.StringReader;
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
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getDeal(@PathParam("id") String id) {
        Deal deal = CSP.getDeal(id);
        Gson gson = new Gson();
        return gson.toJson(deal);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addVote(String body) {

//        Gson gson = new Gson();
//        Deal jsonObject =  gson.from();
//        System.out.println(jsonObject.getDealname());
        return "test";
    }

}
