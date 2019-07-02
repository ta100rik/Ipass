package persistence;

import baseDao.MysqlbaseDao;
import domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMysqlDao extends MysqlbaseDao implements UserDao {
   public List<Users> getAllUsers(){
    Connection con = super.getConnection();
    List<Users> allUsers = new ArrayList<Users>();
    try {
        Statement statement = con.createStatement();
        ResultSet resultSet = null;
        resultSet = statement.executeQuery("SELECT * FROM users join rollen on users.rol = rollen.Rolid ");
        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String Rolnaam = resultSet.getString("Rolnaam");
            Users new_user = new Users(id,email,Rolnaam);
            allUsers.add(new_user);
        }
        con.close();
        return allUsers;
    } catch(SQLException e) {
        e.printStackTrace();
    }
        return allUsers;
   }
   public String Login(String username){
       Connection con = super.getConnection();
       try {
           Statement statement = con.createStatement();
           PreparedStatement st = con.prepareStatement("SELECT Wachtwoord FROM users where email = ? limit 1 ");
           st.setString(1,username);
           ResultSet resultSet = st.executeQuery();

           while (resultSet.next()) {
               String Wachtwoord = resultSet.getString("Wachtwoord");
               return Wachtwoord;
           }
           super.closeConn(con);
           return "";
       } catch(SQLException e) {
           e.printStackTrace();
       }
       return "";
   }
    public Users getUserData(String username){
        Connection con = super.getConnection();
        try {
            Statement statement = con.createStatement();
            PreparedStatement st = con.prepareStatement("SELECT * FROM users join rollen on users.rol = rollen.Rolid where users.email =  ? limit 1 ");
            st.setString(1,username);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String Rolnaam = resultSet.getString("Rolnaam");
                Users new_user = new Users(id,email,Rolnaam);
                return new_user;
            }
            super.closeConn(con);
            return null;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Boolean updateUser(Users us){
        Connection con = super.getConnection();
        try {
            Statement statement = con.createStatement();
            PreparedStatement st = con.prepareStatement("UPDATE users SET email = ?, Rol = ?, vendor = ? WHERE id = ?");
            st.setString(1,us.getEmail());
            st.setString(2,us.getRol());
            st.setString(3,us.getVendor());
            st.setInt(4,us.getId());
            int resultSet = st.executeUpdate();

            super.closeConn(con);
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean insertUser(Users us){
        Connection con = super.getConnection();
        try {
            Statement statement = con.createStatement();
            PreparedStatement st = con.prepareStatement("INSERT INTO users (email, Rol ,vendor) VALUES (?,?,?)");
            st.setString(1,us.getEmail());
            st.setString(2,us.getRol());
            st.setString(3,us.getVendor());
            boolean resultSet = st.execute();
            super.closeConn(con);
            return resultSet;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(Integer id){
        Connection con = super.getConnection();
        try {
            Statement statement = con.createStatement();
            PreparedStatement st = con.prepareStatement("DELETE FROM users where id = ?");
            st.setInt(1,id);
            boolean resultSet = st.execute();
            super.closeConn(con);
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
