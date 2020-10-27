package com.offcn.controller;

import com.offcn.pojo.Movie;
import com.offcn.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/movie")
    public Movie getMovie() {
        System.out.println("买票通道是" + port);
        return movieService.getMovie();
    }
}
