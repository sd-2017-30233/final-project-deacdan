package Business;

/**
 * Created by dandeac on 13/05/2017.
 */
public class Hall {
    private int id;
    private int capacity;

    public Hall(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
