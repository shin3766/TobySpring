package com.yoosup.springstudy;

import com.yoosup.springstudy.domain.user.DaoFactory;
import com.yoosup.springstudy.domain.user.User;
import com.yoosup.springstudy.domain.user.UserDao;
import com.yoosup.springstudy.domain.user.UserDaoJdbc;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserDaoJdbcTest {

    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);

        this.dao = context.getBean("userDao", UserDaoJdbc.class);
        this.user1 = new User("gyumee", "박성철", "springno1");
        this.user2 = new User("leegw700", "이길원", "springno2");
        this.user3 = new User("bumjin", "박범진", "springno3");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        User user = new User();

        dao.deleteAll();
        dao.getCount();

        user.setId("one");
        user.setName("yoosup");
        user.setPassword("hi");

        dao.add(user);
        assertThat(dao.getCount(), is(1));

        User user2 = dao.get("one");

        assertThat(user.getName(), is(user2.getName()));
        assertThat(user.getPassword(), is(user2.getPassword()));
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        User user1 = new User("gyumee", "박규미", "ps001");
        User user2 = new User("goomu", "최고무", "ps002");
        User user3 = new User("minnnu", "신민우", "ps003");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test
    public void deleteAllTest() {

    }

    @Test
    public void duplicateKey() {
        dao.deleteAll();

        dao.add(user1);

        Assertions.assertThrows(DataAccessException.class, () ->
                    dao.add(user1)
                );
    }


}
