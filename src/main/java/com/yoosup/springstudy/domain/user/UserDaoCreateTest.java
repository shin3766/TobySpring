package com.yoosup.springstudy.domain.user;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoCreateTest {
    public static void main(String[] args) {
        DaoFactory daoFactory = new DaoFactory();

        UserDao userDao1 = new DaoFactory().userDao();
        UserDao userDao2 = new DaoFactory().userDao();

        System.out.println("userDao1 = " + userDao1);
        System.out.println("userDao2 = " + userDao2);

        System.out.println(userDao1.equals(userDao2));

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao userDao3 = context.getBean("userDao", UserDao.class);
        UserDao userDao4 = context.getBean("userDao", UserDao.class);

        System.out.println("userDao3 = " + userDao3);
        System.out.println("userDao4 = " + userDao4);
    }
}
