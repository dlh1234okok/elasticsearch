package com.dlh.springbootes.dao;

import com.dlh.springbootes.entity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * @author: dulihong
 * @date: 2019/1/24 16:25
 */
public interface UserDao extends ElasticsearchRepository<UserEntity, String> {
}
