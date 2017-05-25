package Business;

/**
 * Created by dandeac on 13/05/2017.
 */
public class Movie {
    private int id;
    private String name;
    private String description;
    private  String director;
    private float rank;
    private String image;

    public Movie(int id, String name, String description, String director, float rank, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.director = director;
        this.rank = rank;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
