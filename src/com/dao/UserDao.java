package com.dao;

import com.bean.User;

public interface UserDao {
//-1 失败 1 管理员 2学生登入
    int login(User user);
    boolean insert(User user);
    boolean del(String uname);
    boolean update(User user);
    User select(String uname);


}
