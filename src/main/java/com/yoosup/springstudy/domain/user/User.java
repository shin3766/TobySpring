package com.yoosup.springstudy.domain.user;

public class User {

    String id;
    String name;
    String password;

    Level level;

    public int getLogin() {
        return login;
    }

    public int getRecommand() {
        return recommand;
    }

    int login;
    int recommand;

    public User(String id, String name, String password, Level level, int login, int recommand) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.login = login;
        this.recommand = recommand;
    }

    public User() { }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
