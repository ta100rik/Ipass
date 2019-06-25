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
}
