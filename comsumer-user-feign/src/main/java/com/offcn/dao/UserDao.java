package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public User getUser(Integer id) {
        return new User(id, "辉仔仔");
    }
}
