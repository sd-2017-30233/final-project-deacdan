package Business;

/**
 * Created by dandeac on 18/05/2017.
 */
public class Schedule {

    private int id;
    private String movieName;
    private int hallID;
    private int leftCapacity;
    private String hours;

    public Schedule(int id, String movieName, int hallID, int leftCapacity, String hours) {
        this.id = id;
        this.movieName = movieName;
        this.hallID = hallID;
        this.leftCapacity = leftCapacity;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(int leftCapacity) {
        this.leftCapacity = leftCapacity;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
