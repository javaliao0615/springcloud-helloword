package com.offcn.service;

import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MovieFeignExceptionHandleService implements MovieServiceFeign {
    @Override
    public Movie getMovie() {
        //买票
        Movie movie = new Movie(-2, "票已售空");
        return movie;
    }
}
