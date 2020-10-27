package com.offcn.dao;

import com.offcn.pojo.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
    public Movie getNewMovie() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("阿辉遇难记");
        return movie;
    }
}
