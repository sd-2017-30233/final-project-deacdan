package Business;

import Data.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dandeac on 13/05/2017.
 */
public class AdminBusiness {

    public static void addMovie(String name,String description,String director, float rank, String image) throws Exception {
        int id;

        id = ThreadLocalRandom.current().nextInt(0, 100000);



            Movie movie = new Movie(id, name, description, director, rank, image);

            MovieManagement.addMovie(movie);

    }

    public static void removeMovie(int id) throws Exception {
         MovieManagement.deleteMovie(id);
    }

    public static void updateMovie(int oldID, String name,String description,String director, float rank, String image) throws Exception{
        int id;


            id = ThreadLocalRandom.current().nextInt(0, 100000);



            Movie movie = new Movie(id,name,description,director,rank,image);
            MovieManagement.updateMovie(oldID,movie);


    }

    public static ResultSet viewMovieByName(String name) throws Exception{
        return MovieManagement.viewMovieByName(name);
    }

    public static ResultSet viewMovieByID(int id) throws Exception{
        return MovieManagement.viewMovieByID(id);
    }

    public static ResultSet viewAllMovies() throws Exception{
        return MovieManagement.viewAllMovies();
    }

    public static void addHall(int id, int capacity) throws Exception{

            Hall hall = new Hall(id, capacity);
            HallManagement.addHall(hall);

    }

    public static void deleteHall(int id) throws Exception{
        HallManagement.deleteHall(id);
    }

    public static void updateHall(int oldID,int id, int capacity) throws Exception{

            Hall hall = new Hall(id, capacity);
            HallManagement.updateHall(oldID, hall);

    }
    public static ResultSet viewHalls() throws Exception{
        return HallManagement.viewAllHalls();
    }

    public static ResultSet viewHallCapacity(int id) throws Exception{
        return HallManagement.viewHallCapacity(id);
    }
    public static ResultSet viewHallByID(int id) throws Exception{
        return HallManagement.viewHallByID(id);
    }

    public static ResultSet viewReservationByID(int id) throws Exception{
        return ReservationManagement.viewReservationByID(id);
    }

    public static ResultSet viewReservationByUsername(String username) throws Exception{
        return ReservationManagement.viewReservationByUsername(username);
    }

    public static ResultSet viewAllReservations() throws Exception{
        return ReservationManagement.viewAllReservations();
    }

    public static ResultSet viewUserByUsername(String username) throws Exception{
        return UserManagement.viewUser(username);
    }

    public static ResultSet viewAllUsers() throws Exception{
        return UserManagement.viewAllUsers();
    }

    public static void addSchedule(int id, String movieName, int hallID, int leftCapacity, String hours)throws Exception{
        Schedule schedule = new Schedule(id,movieName,hallID,leftCapacity,hours);

        ScheduleManagement.addSchedule(schedule);
    }

    public static void deleteSchedule(int id) throws Exception{
        ScheduleManagement.deleteSchedule(id);
    }

    public static void updateSchedule(int id,int newID, String newMovieName, int newHallID, int newLeftCapacity, String newHours) throws Exception{
        ScheduleManagement.updateSchedule(id,newID,newMovieName,newHallID,newLeftCapacity,newHours);
    }

    public static ResultSet viewScheduleByID(int id) throws Exception{
        return ScheduleManagement.viewScheduleByID(id);
    }
    public static ResultSet viewAllSchedule() throws Exception{
        return ScheduleManagement.viewAllSchedule();
    }

    public static ResultSet viewScheduleByMovie(String movieName) throws Exception{
        return ScheduleManagement.viewScheduleByMovieName(movieName);
    }
}
