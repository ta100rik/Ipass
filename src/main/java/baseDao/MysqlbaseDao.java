package baseDao;

import java.sql.*;

public class MysqlbaseDao {/*initilizing a base connection*/
        public Connection getConnection(){
//            trying to make connection otherwise retrun null
            try{
//                getting the drive from maven (desk)
                Class.forName("com.mysql.jdbc.Driver");
//                makking a connection
                Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dealregister?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
//                returning the connection
                return con;

        }catch(Exception e){ System.out.println(e);}
//            if something goes wrong it will print the error other wise it will return null or the conneciton
            return null;
    }
    public void closeConn(Connection con) throws SQLException {
//            for best practice closing the connection
        con.close();
    }

}
