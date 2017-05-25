package Business;

import Data.MovieManagement;
import Data.ReservationManagement;
import Data.ScheduleManagement;
import Data.UserManagement;

import java.sql.ResultSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dandeac on 13/05/2017.
 */
public class UserBusiness {
    public static boolean isUser(String username) throws Exception{
        ResultSet rs = UserManagement.viewUser(username);
        if(rs.next()) return true;
        else return false;
    }

    public static boolean loginVerification(String username, String password) throws Exception{
        ResultSet rs = UserManagement.viewUser(username);

        while (rs.next()) {

            String usr = rs.getString("username");
            String pass = rs.getString("password");


            if (username.equalsIgnoreCase(usr) && password.equalsIgnoreCase(pass))
                return true;

        }
return false;
    }

    public static void addUser(String username,String password,String email) throws Exception{
        User user = new User(username,password,email);
        UserManagement.addUser(user);
    }

    public static void addReservation(int id,String username,int scheduleID,int seats) throws Exception{

        Reservation reservation = new Reservation(id,username,scheduleID,seats);
        ReservationManagement.addReservation(reservation);

    }


    public static ResultSet viewMovieNames() throws Exception{
        return MovieManagement.viewAllMovieNames();
    }

    public static ResultSet viewMovieByName(String name) throws Exception{
        return MovieManagement.viewMovieByName(name);
    }

    public static ResultSet scheduleForMovie(String movieName) throws Exception{
        return ScheduleManagement.viewScheduleByMovieName(movieName);
    }

    public static ResultSet viewScheduleByID(int id) throws Exception{
        return ScheduleManagement.viewScheduleByID(id);
    }
    public static void updateScheduleCapacity(int id,int newSeats) throws Exception{
        ScheduleManagement.updateScheduleCapacity(id,newSeats);
    }

    public static void updateReservation(int id, int newScheduleID, int newSeats) throws Exception{
        ReservationManagement.updateReservation(id,newScheduleID,newSeats);
    }
    public static void removeReservationByID(int id) throws Exception{
        ReservationManagement.deleteReservationByID(id);
    }


    public static ResultSet viewReservationByID(int id) throws Exception{
        return ReservationManagement.viewReservationByID(id);
    }

    public static ResultSet viewReservationByUsername(String username) throws Exception{
        return ReservationManagement.viewReservationByUsername(username);
    }
    public static ResultSet viewUserDetails(String username) throws Exception {
        return UserManagement.viewUser(username);
    }

}
