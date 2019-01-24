package com.dlh.springbootes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author: dulihong
 * @date: 2019/1/24 16:23
 */
@Document(indexName = "test",type = "user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 3783616200116479048L;
    @Id
    private String id;

    private String name;

    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
