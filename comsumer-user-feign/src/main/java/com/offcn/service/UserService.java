package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MovieServiceFeign movieServiceFeign;

    public User getUserById(Integer id) {
        return userDao.getUser(id);
    }

    //买电影票
    public Map<String, Object> buyMovie(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //查询用户信息
        User user = this.getUserById(id);
        map.put("user", user);
        //买票
        Movie movie = movieServiceFeign.getMovie();//实现类在远程调用服务商
        map.put("movie", movie);
        return map;
    }
}
