package Data;

import Business.Hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dandeac on 13/05/2017.
 */
public class HallManagement {

    public static void addHall(Hall hall) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `halls`(`id`, `capacity`) VALUES ('"+hall.getId()+"','"+hall.getCapacity()+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void updateHall(int id,Hall hall) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `halls` SET `id`='"+hall.getId()+"',`capacity`='"+hall.getCapacity()+"' WHERE `id`='"+id+"'");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void deleteHall(int id) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `halls` WHERE (`id`='"+id+"')");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static ResultSet viewHallByID(int id) throws Exception{
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `capacity` FROM `halls` WHERE `id`='"+id+"'");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;
    }

    public static ResultSet viewAllHalls() throws Exception{
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `capacity` FROM `halls`");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;
    }

    public static ResultSet viewHallCapacity(int id) throws Exception{
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `capacity` FROM `halls` WHERE `id`='"+id+"'");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;
    }
}
