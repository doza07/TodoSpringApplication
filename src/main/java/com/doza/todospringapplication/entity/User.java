package com.doza.todospringapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class User {

    @Id
    private long id;
    private String username;
    @ManyToOne
    @JoinColumn(name = "id")
    private UserInfo userInfo;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + username + '\'' +
               ", userInfo=" + userInfo +
               '}';
    }
}
