package web;

import Utils.Password;
import Utils.Tokenbuilder;
import com.google.gson.Gson;

import domain.Users;
import io.jsonwebtoken.impl.crypto.MacProvider;
import service.ServiceProvider;
import service.UserServiceProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.List;

@Path("users")
public class UsersController {
    final static public Key key = MacProvider.generateKey();
    private Password PasswordClass = new Password();
    private Tokenbuilder tokenBuilder = new Tokenbuilder(key);
    private UserServiceProvider USP = ServiceProvider.getUserServiceProvider();
    @GET
    @Produces("application/json")
    public String getAllusers(){
        List<Users> Users = USP.getUsers();
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
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username, @FormParam ("password") String password){
        final String passwordhash = USP.Login(username);
        final boolean Result = PasswordClass.verifyHash(password,passwordhash);
        if(Result){
            Users user = USP.getUserData(username);
            final String RESULT = tokenBuilder.createUserToken(user);
            return Response.ok(RESULT).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }
}
