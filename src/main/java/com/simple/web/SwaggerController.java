package com.simple.web;

import com.simple.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by songyigui on 2016/10/17.
 */
@RestController
@RequestMapping(value = "/users")
public class SwaggerController {

//    @ApiOperation(value = "Get All User", notes = "requires nothing")
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

//    @ApiOperation(value = "Get User with id",notes = "requires the id of user")
    @RequestMapping(value="/{name}",method = RequestMethod.GET)
    public User getUserById(@PathVariable String name){
        User user = new User();
        user.setName("hello world");
        return user;
    }
}
