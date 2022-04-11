package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection con;
    public static Connection getConnection() {
        try {
            if(con==null) {
//            driver class load
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                
//                create connection
                
                con=DriverManager.getConnection("jdbc:mysql://localhost/partyanduserdetail", "root","Abhishek12345@");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
        return con;
    }

}
