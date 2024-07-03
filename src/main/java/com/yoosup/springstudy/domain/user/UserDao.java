package com.yoosup.springstudy.domain.user;

import java.sql.*;

public class UserDao {
    private static UserDao INSTANCE;

    private UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public static synchronized UserDao getInstance() {
        if (INSTANCE == null) INSTANCE = new UserDao(???);
        return INSTANCE;
    }

    private ConnectionMaker connectionMaker;

//    public UserDao(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
//
//    public class NUserDao extends UserDao {
//
//        @Override
//        public Connection getConnection() throws SQLException, ClassNotFoundException {
//            // N사 DB connection 생성 코드
//            return null;
//        }
//    }
//
//    public class DUserDao extends UserDao {
//        @Override
//        public Connection getConnection() throws SQLException, ClassNotFoundException {
//            // D사 DB connection 생성 코드
//            return null;
//        }
//    }

}
