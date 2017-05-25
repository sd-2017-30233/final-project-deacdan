package Data;

import Business.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dandeac on 18/05/2017.
 */
public class ScheduleManagement {
    public static boolean isNotSchedule(int id) throws Exception{
        ResultSet rs = viewScheduleByID(id);

        if(rs.next()) return false;
        return true;
    }
    public static void addSchedule(Schedule schedule) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `schedule`(`id`, `movieName`, `hallID`, `leftCapacity`, `hours`) VALUES ('"+schedule.getId()+"','"+schedule.getMovieName()+"','"+schedule.getHallID()+"','"+schedule.getLeftCapacity()+"','"+schedule.getHours()+"')");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void deleteSchedule(int id) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `schedule` WHERE (`id`='"+id+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void updateSchedule(int id,int newID, String newMovieName, int newHallID, int newLeftCapacity, String newHours) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `schedule` SET `id`='"+newID+"',`movieName`='"+newMovieName+"',`hallID`='"+newHallID+"',`leftCapacity`='"+newLeftCapacity+"',`hours`='"+newHours+"' WHERE `id`='"+id+"'");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }


    public static void updateScheduleCapacity(int id, int leftCapacity) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `schedule` SET `leftCapacity`='"+leftCapacity+"' WHERE `id`='"+id+"'");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static ResultSet viewScheduleByID(int id) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `movieName`, `hallID`, `leftCapacity`, `hours` FROM `schedule` WHERE `id`='"+id+"'");

            return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewScheduleByMovieName(String movieName) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `movieName`, `hallID`, `leftCapacity`, `hours` FROM `schedule` WHERE `movieName`='"+movieName+"'");

            return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewAllSchedule() throws Exception{
        Connection conn = Connect.getConnection();

        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `movieName`, `hallID`, `leftCapacity`, `hours` FROM `schedule`");

            return rs;

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
        return null;

    }
}
