package com.offcn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Integer id) {
        return userDao.getUser(id);
    }

    //买电影票
    @HystrixCommand(fallbackMethod = "buyMovieFailBackMethod")
    public Map<String, Object> buyMovie(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //查询用户信息
        User user = this.getUserById(id);
        map.put("user", user);
        //买票
        Movie movie = restTemplate.getForObject("http://PROVIDEMOVIE/movie", Movie.class);
        map.put("movie", movie);
        return map;
    }

    public Map<String, Object> buyMovieFailBackMethod(Integer id) {
        Map<String, Object> map = new HashMap<>();
        User user = new User(-1, "不存在的用户");
        map.put("user", user);
        //买票
        Movie movie = new Movie(-2, "票已售空");
        map.put("movie", movie);
        return map;
    }
}
