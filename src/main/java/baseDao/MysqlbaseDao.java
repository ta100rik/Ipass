package baseDao;

import java.sql.*;

public class MysqlbaseDao {
        public Connection getConnection(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo","root","root");
                return con;

        }catch(Exception e){ System.out.println(e);}
            return null;
    }
    public void closeConn(Connection con) throws SQLException {
        con.close();
    }

}
