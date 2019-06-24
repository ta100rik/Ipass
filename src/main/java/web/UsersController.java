package web;

import com.google.gson.Gson;
import domain.Customer;
import domain.Users;
import service.ServiceProvider;
import service.UserServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("users")
public class UsersController {
    private UserServiceProvider CSP = ServiceProvider.getUserServiceProvider();
    @GET
    @Produces("application/json")
    public String getAllusers(){
        List<Users> Users = CSP.getUsers();
        Gson gson = new Gson();
        String result = "{";
        int counter = 0;
        final int totalrowcount = Users.size();
        for (Users user:Users) {
            result += "\"" +counter + "\":";
            String json = gson.toJson(user);
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
