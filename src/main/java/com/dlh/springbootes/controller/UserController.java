package com.dlh.springbootes.controller;

import com.dlh.springbootes.dao.UserDao;
import com.dlh.springbootes.entity.UserEntity;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.elasticsearch.common.io.FileSystemUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Optional;

/**
 * @author: dulihong
 * @date: 2019/1/24 16:26
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @PostMapping
    public UserEntity addUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUser(@PathVariable String id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userDao.deleteById(id);
        return "success";
    }

    @GetMapping
    public Iterable<UserEntity> getAllUser() {
        return userDao.findAll();
    }

    @GetMapping("search")
    public Iterable<UserEntity> search() {
        return userDao.search(QueryBuilders.wildcardQuery("name", "*h*"));
    }

}
