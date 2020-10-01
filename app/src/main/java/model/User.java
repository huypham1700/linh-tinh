package model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String tokenKey;

    public User(String username, String password, String tokenKey) {
        this.username = username;
        this.password = password;
        this.tokenKey = tokenKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
