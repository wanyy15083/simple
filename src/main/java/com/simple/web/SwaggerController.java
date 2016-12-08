package com.simple.web;

import com.simple.model.User;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyigui on 2016/10/17.
 */
@RestController
@RequestMapping(value = "/users")
public class SwaggerController {

    @ApiOperation(value = "Get All User", notes = "requires nothing")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("hello");
        list.add(user);
        User user2 = new User();
        user2.setName("world");
        list.add(user2);
        return list;
    }

    @ApiOperation(value = "Get User with id",notes = "requires the id of user")
    @RequestMapping(value="/{name}",method = RequestMethod.GET)
    public User getUserById(@PathVariable String name){
        User user = new User();
        user.setName("hello world");
        return user;
    }
}
