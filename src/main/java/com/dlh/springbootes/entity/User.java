package com.dlh.springbootes.entity;

import java.io.Serializable;

/**
 * @author: dulihong
 * @date: 2019/3/22 15:10
 */
public class User implements Serializable {


    private static final long serialVersionUID = -1880703537793886563L;

    private String id;

    private String name;

    private String pwd;

    private Long createdAt;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
