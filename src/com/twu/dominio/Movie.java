package com.twu.dominio;

import com.twu.biblioteca.Item;

public class Movie extends Item {

    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean movieIsCheckedOut;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = validateRating(rating);
        setItemCheckedOut(false, null);
    }

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = 0;
        setItemCheckedOut(false, null);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    private String outputStringRating() {
        String ratingOutput;
        if(rating == 0){
            ratingOutput = "unrated";
        }else {
            ratingOutput = String.valueOf(rating);
        }
        return ratingOutput;
    }

    @Override
    public String itemDetails() {
        String ratingOutput = outputStringRating();
        return String.format("%-30s%-30s%-10s%-10s\n", name, director, year, ratingOutput);
    }

    private int validateRating(int rating) {
        if(rating >= 1 && rating <= 10){
            return rating;
        }
        return 0;
    }

    @Override
    public boolean isItemCheckedOut() {
        return movieIsCheckedOut;
    }

    @Override
    public void setItemCheckedOut(boolean movieIsCheckedOut, String userResponsible) {
        this.movieIsCheckedOut = movieIsCheckedOut;
    }
}
