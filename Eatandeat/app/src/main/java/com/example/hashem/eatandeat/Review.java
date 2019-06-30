package com.example.hashem.eatandeat;
public class Review {
    String name;
    String rating;
    String date;
    String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    static final Review[] reviews = {
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),
            new Review("John Doe","4 of 5","1/2/2018","Such a good service"),



    };
    public Review(String name, String rating, String date, String desc) {
        this.name = name;
        this.rating = rating;
        this.date = date;
        this.desc = desc;
    }
}
