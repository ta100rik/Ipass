package persistence;

import domain.Users;

import java.util.List;

public interface UserDao {
    List<Users> getAllUsers();
    String Login(String username);
}
