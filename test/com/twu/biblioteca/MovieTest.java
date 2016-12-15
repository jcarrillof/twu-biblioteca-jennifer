package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie = new Movie("Movie One", 2014, "Director One", 5);
    private Movie movieNoRated = new Movie("Movie Two", 1998, "Director Two");

    @Test
    public void shouldReturnMovieNameWhenCreated() {
        assertEquals("Movie One", movie.getName());
    }

    @Test
    public void shouldReturnMovieYearWhenCreated() {
        assertEquals(2014, movie.getYear());
    }

    @Test
    public void shouldReturnMovieDirectorWhenCreated() {
        assertEquals("Director One", movie.getDirector());
    }

    @Test
    public void shouldReturnMovieRatingWhenCreated() {
        assertEquals(5, movie.getRating());
    }

    @Test
    public void shouldReturnZeroWhenRatingNotGivenWhenCreated() {
        assertEquals(0, movieNoRated.getRating());
    }

    @Test
    public void shouldReturnMovieNoRatedNameWhenCreated() {
        assertEquals("Movie Two", movieNoRated.getName());
    }

    @Test
    public void shouldReturnMovieNoRatedYearWhenCreated(){
        assertEquals(1998, movieNoRated.getYear());
    }

    @Test
    public void shouldReturnMovieNoRatedDirectorWhenCreated() {
        assertEquals("Director Two", movieNoRated.getDirector());
    }

    @Test
    public void shouldReturnZeroWhenGivenNotValidMovieRating() {
        Movie movieNoValidRating = new Movie("Movie Three", 2004, "Director Three", 23);
        assertEquals(0, movieNoValidRating.getRating());
    }

    @Test
    public void shouldReturnRatingInStringOfMovieDetailsWhenRated(){
        String expected = String.format("%-30s%-30s%-10s%-10s\n","Movie One", "Director One", 2014, 5);
        assertEquals(expected, movie.movieDetails());
    }

    @Test
    public void shouldReturnUnratedInStringOfMovieDetailsWhenNoRated() {
        String expected = String.format("%-30s%-30s%-10s%-10s\n","Movie Two", "Director Two", 1998, "unrated");
        assertEquals(expected, movieNoRated.movieDetails());
    }

    @Test
    public void shouldSetCheckoutFalseWhenMovieIsCreated() {
        assertFalse(movie.isMovieCheckout());
    }

    @Test
    public void shouldSetCheckoutFalseWhenMovieNotRatedIsCreated() {
        assertFalse(movieNoRated.isMovieCheckout());
    }

    @Test
    public void shouldReturnTrueWhenBookIsCheckedOut() {
        movie.setMovieIsCheckedOut(true);
        assertTrue(movie.isMovieCheckout());
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotCheckedOut() {
        movieNoRated.setMovieIsCheckedOut(false);
        assertFalse(movieNoRated.isMovieCheckout());
    }
}
