package com.beans.beanUser;

import javax.servlet.http.HttpSession;

/**
 * Created by FlipBook TP300LD on 06.11.2016.
 */
public class User {
    private String name;
    private String auth;

    public User(String name, String auth) {
        this.name = name;
        this.auth = auth;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public static User get(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            session.setAttribute("user", user);
        }
        return user;
    }
}
