package model;

import java.util.ArrayList;

public class Game {
    private int id;
    private String name;
    private String imageURL;
    private String description;
    private String shortDescription;
    private float rating;

    public Game() {
    }

    public Game(int id,String name,String imageURL, String description, String shortDescription, float rating) {
        this.id=id;
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.shortDescription = shortDescription;
        this.rating = rating;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ArrayList<Game> generateFakeData(){
        ArrayList<Game> listGame = new ArrayList<>();
        listGame.add(new Game(1,"cod","https://venturebeat.com/wp-content/uploads/2020/03/unnamed-23.jpg?resize=1024%2C600&strip=all" ,"GOOD GAMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE","GOOD", 4));
        listGame.add(new Game(2,"bf5","https://s15.postimg.cc/nv8hje9cr/bf5.png"," PRETTY GOOD GAMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE","PRETTY GOOD", 3));
        listGame.add(new Game(3,"apex legend" ,"https://assets1.ignimgs.com/2019/02/04/apex-legends---button-fin-1549319070496.jpg?width=188","BAD GAMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE","BAD", 2));
        return listGame;
    }
}
