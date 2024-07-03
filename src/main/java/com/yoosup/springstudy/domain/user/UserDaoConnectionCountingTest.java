package com.yoosup.springstudy.domain.user;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        //
        // DAO 사용 코드
        //
        CountingConnectionMaker ccm = context.getBean("connectionMaker",
                CountingConnectionMaker.class);
        System.out.println("ccm.getCounter() = " + ccm.getCounter());

    }
}
