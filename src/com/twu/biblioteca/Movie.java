package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = validateRating(rating);
    }

    private int validateRating(int rating) {
        if(rating >= 1 && rating <= 10){
            return rating;
        }
        return 0;
    }

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = 0;
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

    public String movieDetails() {
        String ratingOutput = outputStringRating();
        return String.format("%-30s%-30s%-10s%-10s\n", name, director, year, ratingOutput);
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
}
