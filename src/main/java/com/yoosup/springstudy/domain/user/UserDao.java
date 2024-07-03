package com.yoosup.springstudy.domain.user;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker;
    private Connection c;
    private User user;

    public User get(String id) throws ClassNotFoundException, SQLException {
        this.c = connectionMaker.makeConnection();
        this.user = new User();
        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));
        return this.user;
    }

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
