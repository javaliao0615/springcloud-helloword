package com.offcn.service;

import com.offcn.pojo.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "PROVIDEMOVIE", fallback = MovieFeignExceptionHandleService.class)//要与调动服务的名称保持一致
public interface MovieServiceFeign {
    @GetMapping("/movie")
    public Movie getMovie();
}
