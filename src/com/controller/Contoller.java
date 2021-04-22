package com.controller;

import com.bean.User;
import com.dao.UserDaoImpl;
import com.view.View;

public class Contoller {
    public static void main(String[] args) {
            while (true){
            User user = View.indexView();
            UserDaoImpl userDao= new UserDaoImpl();
            int type = userDao.login(user);
            switch(type){
                case -1:
                    System.out.println("登入失败");
                    break;
                case 1:
                    System.out.println("管理员登入");
                    mangersever();
                    break;
                case 2:
                    System.out.println("学生登入");
                    studentsever(user.getUname());
                    break;
                    }


            }
        }


    private static void mangersever() {
        int num = View.Manager();
        UserDaoImpl userDao = new UserDaoImpl();
        boolean flag = true;
        while (flag) {
            switch (num) {
                case 0:
                    System.out.println("管理员系统退出");
                    flag = false;
                    break;
                case 1:
                    User user = View.add();
                    flag = userDao.insert(user);
                    System.out.println(flag?"add成功":"add失败");
                    break;
                case 2:
                    String uname = View.del();
                    flag = userDao.del(uname);
                    System.out.println(flag?"del成功":"del失败");
                    break;

                case 3:
                    User updateuser = View.update();
                    flag = userDao.update(updateuser);
                    System.out.println(flag?"update成功":"update失败");
                    break;

                case 4:
                    String uname1=View.select();
                    User selectuser = userDao.select(uname1);
                    selectuser.toString();
                    System.out.println(selectuser);
                    break;

                default:
                    break;


            }
        }
    }

    private static void studentsever(String uname) {

        int num = View.studentMenuView();
        switch (num){
            case 0:
                System.out.println("退出成功");
                break;
            case 1:
                String upass = View.alterPassView();
                UserDaoImpl userDao = new UserDaoImpl();
                userDao.update(new User(uname,upass));
                System.out.println("修改成功");
        }


    }
}
