package Data;

import Business.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dandeac on 13/05/2017.
 */
public class MovieManagement {



    public static void addMovie(Movie movie) throws Exception{
        Connection conn = Connect.getConnection();

        try{

            PreparedStatement posted = conn.prepareStatement("INSERT INTO `movies`(`id`, `name`, `description`,`director`, `rank`, `image`) VALUES ('"+movie.getId()+"','"+movie.getName()+"','"+movie.getDescription()+"','"+movie.getDirector()+"','"+movie.getRank()+"','"+movie.getImage()+"')");

            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);
    }

    public static void updateMovie(int oldMovieID, Movie movie) throws Exception{
        Connection conn = Connect.getConnection();
        try{

            PreparedStatement posted = conn.prepareStatement("UPDATE `movies` SET `id`='"+movie.getId()+"',`name`='"+movie.getName()+"',`description`='"+movie.getDescription()+"',`director`='"+movie.getDirector()+"',`rank`='"+movie.getRank()+"',`image`='"+movie.getImage()+"' WHERE `id`='"+oldMovieID+"'");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);

    }

    public static ResultSet viewMovieByID(int id) throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `name`,`description`, `director`, `rank`, `image` FROM `movies` WHERE `id`='"+id+"'");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewMovieByName(String name) throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `description`,`director`, `rank`, `image` FROM `movies` WHERE `name`='"+name+"'");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }


    public static ResultSet viewAllMovies() throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id`, `name`,`description`, `director`, `rank` FROM `movies`");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }

    public static ResultSet viewAllMovieNames() throws Exception {
        Connection conn = Connect.getConnection();
        try{

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT `name` FROM `movies`");



            return rs;
        }  catch(Exception e){
            System.out.println(e);

        }

        Connect.closeConnection(conn);
        return null;

    }

    public static void deleteMovie(int id) throws Exception{
        Connection conn = Connect.getConnection();
        try{

            PreparedStatement posted = conn.prepareStatement("DELETE FROM `movies` WHERE `id`='"+id+"'");
            posted.executeUpdate();

        }  catch(Exception e){
            System.out.println(e);
        }

        Connect.closeConnection(conn);

    }

}