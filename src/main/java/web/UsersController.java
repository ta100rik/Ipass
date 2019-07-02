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
/*
*  here all the request with the url api/users will come in
* */
@Path("users")
public class UsersController {
    final static public Key key = MacProvider.generateKey();
    private Password PasswordClass = new Password();
    private Tokenbuilder tokenBuilder = new Tokenbuilder(key);
    private UserServiceProvider USP = ServiceProvider.getUserServiceProvider();

    @GET
    @Produces("application/json")
//    here we adjust the array with the domain Users in it to the a json string to return it to the frontend
    public String getAllusers() {
        List<Users> Users = USP.getUsers();
        Gson gson = new Gson();
        String result = "{";
        int counter = 0;
        final int totalrowcount = Users.size();
        for (Users user : Users) {
            result += "\"" + counter + "\":";
            String json = gson.toJson(user);
            counter++;
            if (counter == totalrowcount) {
                result += json;
            } else {
                result += json + ",";
            }
//            System.out.println(json);
        }
        result = result + "}";
//        System.out.println(result);
        return result;
    }


//here we update a user by receiving the data as a formparam
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateuser(@FormParam("ids") Integer id, @FormParam("email") String email,@FormParam("Rol") String Rol,@FormParam("Vendor") String Vendor) {

        String RESULT = "";
        Users update_user = new Users(id,email,Rol,Vendor);
        final boolean Result = USP.updateUser(update_user);
        if(Result){
            return Response.ok(RESULT).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
//    here is the post function where we receive new users putting it in a object and give it to the provider
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertUser(@FormParam("ids") Integer id, @FormParam("email") String email,@FormParam("Rol") String Rol,@FormParam("Vendor") String Vendor) {

        Users new_user = new Users(id,email,Rol,Vendor);
        boolean Result = USP.insertUser(new_user);
        String RESULT = "succes";
        return Response.ok(RESULT).build();

    }
//    here is the delete function wehere we receive delete id and sending it to the provider
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response Deleteuser(@FormParam("ids") Integer id) {
        boolean Result = USP.deleteUser(id);
        String RESULT = "succes";
        return Response.ok(RESULT).build();

    }
//    this is a special path for login
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    login function will check if the username is in the db
//    afterwards it will check if the hashpassword is equal to the given user password
//    if all correct it will login and return a jwt token generated with the utils.tokenbuilder
//    other wise it will return unauthrizeds
    public Response login(@FormParam("username") String username, @FormParam("password") String password) {
        final String passwordhash = USP.Login(username);
        final boolean Result = PasswordClass.verifyHash(password, passwordhash);
        if (Result) {
            Users user = USP.getUserData(username);
            final String RESULT = tokenBuilder.createUserToken(user);
            return Response.ok(RESULT).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }

}