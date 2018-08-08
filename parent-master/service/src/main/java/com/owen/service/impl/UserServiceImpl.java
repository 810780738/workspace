package com.owen.service.impl;

import com.owen.model.User;
import com.owen.dao.repository.UserRepository;
import com.owen.redisDao.repository.UserRedis;
import com.owen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRedis userRepositoryRedis;

    public User getUser(String name){
        userRepositoryRedis.setKey(name,"小猪");
//        return userRepository.findByName(name);
        User user = new User();
        user.setName(userRepositoryRedis.getValue(name));
        return user;
    }

    @Transactional
    public User saveUser(String name,Integer age, String address){
        User user = new User(name, age, address);
        return userRepository.save(user);
    }
}
