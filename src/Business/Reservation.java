package Business;

/**
 * Created by dandeac on 13/05/2017.
 */
public class Reservation {
    private int id;
    private String userID;
    private int scheduleID;
    private int seats;

    public Reservation(int id, String userID, int scheduleID, int seats) {
        this.id = id;
        this.userID = userID;
        this.scheduleID = scheduleID;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
