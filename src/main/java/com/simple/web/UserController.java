package com.simple.web;

import com.simple.model.User;
import com.simple.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by songyigui on 2016/10/17.
 */
@Controller
public class UserController {
    private Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if (user != null) {
            System.out.println("user.getName():" + user.getName());
            logger.info("user.getAge:" + user.getAge());
        }
        return user;
    }

}
