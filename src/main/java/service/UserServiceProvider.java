package service;

import domain.Users;
import persistence.UserMysqlDao;

import java.util.List;

public class UserServiceProvider {
    private UserMysqlDao UD = new UserMysqlDao();
    public List<Users> getUsers(){
        return UD.getAllUsers();
    }
    public String Login(String username){
        return UD.Login(username);
    }
    public Users getUserData(String username){return UD.getUserData(username);}
    public Boolean updateUser(Users us){return UD.updateUser(us);}
    public Boolean insertUser(Users us){return UD.insertUser(us);}
    public Boolean deleteUser(Integer id){return UD.deleteUser(id);}
}
