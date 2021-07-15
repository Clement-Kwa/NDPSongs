package sg.edu.rp.c346.id20002694.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private 	int id;
    private 	String title;
    private String singers;
    private int year;
    private int stars;

    public Song(  String title, String singers, int year,  int stars) {
        this.singers = singers;
        this.title = title;
        this.year = year;
        this.id = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setSongContent(String title, String singers, int year,  int stars) {
        this.singers = singers;
        this.title = title;
        this.year = year;
        this.id = stars;
    }

    @Override
    public String toString() { return title + "\n" + singers +" - "+year+ "\n";  }



}
