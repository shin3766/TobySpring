package com.yoosup.springstudy.domain.user;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoCreateTest {
    public static void main(String[] args) {
        DaoFactory daoFactory = new DaoFactory();

        UserDaoJdbc userDao1 = new DaoFactory().userDao();
        UserDaoJdbc userDao2 = new DaoFactory().userDao();

        System.out.println("userDao1 = " + userDao1);
        System.out.println("userDao2 = " + userDao2);

        System.out.println(userDao1.equals(userDao2));

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DaoFactory.class);

        UserDaoJdbc userDao3 = context.getBean("userDao", UserDaoJdbc.class);
        UserDaoJdbc userDao4 = context.getBean("userDao", UserDaoJdbc.class);

        System.out.println("userDao3 = " + userDao3);
        System.out.println("userDao4 = " + userDao4);
    }
}
