package com.view;

import com.bean.User;

import java.util.Scanner;

public class View {

    private static Scanner input = new Scanner(System.in);

    public static User indexView(){

        System.out.println("-------------------");
        System.out.println("-------学生系统管理-------");
        System.out.println("-------根据提示操作--------");
        System.out.println("-------请输入账号------------");
        String uname = input.nextLine();
        System.out.println("-------请输入密码------------");
        String upass = input.nextLine();
        System.out.println("-------------------");

        return new User(uname,upass);


    }

    public static Integer Manager(){
        System.out.println("-------------------");
        System.out.println("-------管理员菜单-------");
        System.out.println("-------0 退出--------");
        System.out.println("-------1 增加------------");
        System.out.println("-------2 删减------------");
        System.out.println("-------3 修改------------");
        System.out.println("-------4 查找------------");
        String type = input.nextLine();
        Integer num = Integer.parseInt(type);

        if(num<0 | num>4){
            System.out.println("错误，请重新输入");
            return Manager();

        }

        return num;
    }


    public static User add(){
        System.out.println("***********************************");
        System.out.println("********\t添加用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    public static String del(){
        System.out.println("***********************************");
        System.out.println("********\t删除用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();

        return uname;

    }


    public static User update (){
        System.out.println("***********************************");
        System.out.println("********\t修改用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入新的密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    public static String select(){
        System.out.println("***********************************");
        System.out.println("********\t删除用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();

        return uname;

    }
    public static int studentMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎学生回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.修改密码\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 1) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************");
        return num;
    }
    /**
     * 修改密码界面
     * @return 返回修改的用户类
     */
    public static String alterPassView(){
        System.out.println("***********************************");
        System.out.println("********\t修改密码界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return upass;
    }

}
