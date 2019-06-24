package web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Deal")
public class DealController {
    @GET
    @Produces("application/json")
    public String getDeal(){
        return "Deal";
    }
}
