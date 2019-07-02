package persistence;

import baseDao.MysqlbaseDao;
import domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMysqlDao extends MysqlbaseDao implements UserDao {
   public List<Users> getAllUsers(){
//       getting the connection ready
    Connection con = super.getConnection();
//    making a list of the arrays
    List<Users> allUsers = new ArrayList<Users>();
    try {
//        create the statement
        Statement statement = con.createStatement();
//        result set to null
        ResultSet resultSet = null;
//        run the query
        resultSet = statement.executeQuery("SELECT * FROM users join rollen on users.rol = rollen.Rolid ");
//        loop throught the records
        while (resultSet.next()) {
//      initalize the attributes
            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String Rolnaam = resultSet.getString("Rolnaam");
//            make a object to assign it to the array
            Users new_user = new Users(id,email,Rolnaam);
//            assign the object to the array
            allUsers.add(new_user);
        }
//        close the connection (best practice)
        con.close();
//        return the just created array
        return allUsers;
    } catch(SQLException e) {
//        return the error in the sout if there is one
        e.printStackTrace();
    }
//    return a null because syntax java
        return allUsers;
   }
   public String Login(String username){
//       get connection with the db
       Connection con = super.getConnection();
       try {
//           prepare the statement
           Statement statement = con.createStatement();
//           define the statement
           PreparedStatement st = con.prepareStatement("SELECT Wachtwoord FROM users where email = ? limit 1 ");
//           set the param of the query
           st.setString(1,username);
//           excute it
           ResultSet resultSet = st.executeQuery();
//loop through the records
           while (resultSet.next()) {
//               grab the password to check later in code
               String Wachtwoord = resultSet.getString("Wachtwoord");
//               return the hashed password
               return Wachtwoord;
           }
//           close connection if it in't already out of the function
           super.closeConn(con);
//           return nothing if it is there
           return "";
       } catch(SQLException e) {
           e.printStackTrace();
       }

       return "";
   }
    public Users getUserData(String username){
//       get conenction from extends class
        Connection con = super.getConnection();
        try {
//            create a statement
            Statement statement = con.createStatement();
//            prepare a stement
            PreparedStatement st = con.prepareStatement("SELECT * FROM users join rollen on users.rol = rollen.Rolid where users.email =  ? limit 1 ");
//            set the only variable in the string
            st.setString(1,username);
//            run the query

            ResultSet resultSet = st.executeQuery();
//loop throught the query runned above
            while (resultSet.next()) {
                // loop through every record and init the variables
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String Rolnaam = resultSet.getString("Rolnaam");
//              making a domain
                Users new_user = new Users(id,email,Rolnaam);
//                return the object
                return new_user;
            }
//            close connection and return null if not there
            super.closeConn(con);
            return null;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Boolean updateUser(Users us){
//       make a connection
        Connection con = super.getConnection();
        try {
//            cereate a stement
            Statement statement = con.createStatement();
//            prepare the query
            PreparedStatement st = con.prepareStatement("UPDATE users SET email = ?, Rol = ?, vendor = ? WHERE id = ?");
//            set variables in the query
            st.setString(1,us.getEmail());
            st.setString(2,us.getRol());
            st.setString(3,us.getVendor());
            st.setInt(4,us.getId());
//            run the query
            int resultSet = st.executeUpdate();
//return true if it in't crashed yet
            super.closeConn(con);
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
//        return false if it doesn't worked out
        return false;
    }

    public Boolean insertUser(Users us){
//    make a connection
        Connection con = super.getConnection();
        try {
//            making a statement
            Statement statement = con.createStatement();
//            making a prepared statement4
            PreparedStatement st = con.prepareStatement("INSERT INTO users (email, Rol ,vendor) VALUES (?,?,?)");
//            setting the variables in the query
            st.setString(1,us.getEmail());
            st.setString(2,us.getRol());
            st.setString(3,us.getVendor());
//            execute the query
            boolean resultSet = st.execute();
            super.closeConn(con);
//            return if it worked out

            return resultSet;
        } catch(SQLException e) {
            e.printStackTrace();
        }
//        if it crashed return false
        return false;
    }
    public boolean deleteUser(Integer id){
//       make a connection
        Connection con = super.getConnection();
        try {
//            create the statement
            Statement statement = con.createStatement();
// peparing the query
            PreparedStatement st = con.prepareStatement("DELETE FROM users where id = ?");
//            setting the query parameters
            st.setInt(1,id);
//            runnign the query
            boolean resultSet = st.execute();
            super.closeConn(con);
//            return true if it is done
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
//        return false if it is failed
        return false;
    }
}
