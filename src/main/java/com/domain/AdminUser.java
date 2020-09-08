package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "adminusers")
public class AdminUser {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "pwd")
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
