package Data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dandeac on 13/05/2017.
 */
public class Connect {

    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3305/project";
            Class.forName(driver);
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);


            return conn;

        } catch(Exception e){
            System.out.println(e);
        }


        return null;
    }

    public static void closeConnection(Connection conn) throws Exception{
        try{
            if(conn!=null)
                conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
