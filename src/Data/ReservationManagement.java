package Data;

import Business.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dandeac on 13/05/2017.
 */
public class ReservationManagement {



    public static void addReservation(Reservation reservation) throws Exception{
        Connection conn = Connect.getConnection();


        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `reservation`(`id`,`user`, `schedule`, `seats`) VALUES ('"+reservation.getId()+"','"+reservation.getUserID()+"','"+reservation.getScheduleID()+"','"+reservation.getSeats()+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void deleteReservationByID(int id) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `reservation` WHERE (`id`='"+id+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }


    public static void updateReservation(int id, int newScheduleID, int seats) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `reservation` SET `schedule`='"+newScheduleID+"',`seats`='"+seats+"' WHERE `id`='"+id+"'");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static ResultSet viewReservationByID(int id) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`,`user`, `schedule`, `seats` FROM `reservation` WHERE `id`='"+id+"'");

           return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewReservationByUsername(String username) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `schedule`, `seats` FROM `reservation` WHERE `user`='"+username+"'");

            return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewAllReservations() throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`,`user`, `schedule`, `seats` FROM `reservation`");

            return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }
}

