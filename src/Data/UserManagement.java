package Data;

import Business.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dandeac on 13/05/2017.
 */
public class UserManagement {
    public static void addUser(User user) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `users`(`username`, `password`, `email`) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static ResultSet viewUser(String username) throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `username`, `password`, `email` FROM `users` WHERE `username`='"+username+"'");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewAllUsers() throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `username`, `password`, `email` FROM `users` ");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }

}
