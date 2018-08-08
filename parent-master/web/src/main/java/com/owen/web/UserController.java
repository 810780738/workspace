package com.owen.web;

import com.owen.model.User;
import com.owen.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;


    @ApiOperation(value = "获取用户",notes = "获取用户")
    @RequestMapping(value = "/user/{name}",method = RequestMethod.GET)
    public String getUserInfo(@PathVariable(name = "name")String name, ModelMap modelMap){
        log.info("根据用户名查询用户name:"+name);
        User user= userService.getUser(name);
        log.info("根据用户名查询用户查到用户"+user.toString());
        return user.toString();
    }

    @RequestMapping(value = "/save/{name}/{age}/{address}",method = RequestMethod.GET)
    public String saveUserInfo(@PathVariable(name = "name")String name,@PathVariable(name = "age")Integer age,@PathVariable(name = "address")String address,ModelMap modelMap){
        User user= userService.saveUser(name,age,address);
        return user.toString();
    }

}