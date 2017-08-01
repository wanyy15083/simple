package com.simple.web;

import com.simple.model.User;
import com.simple.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/user")
    public String indexUser(Model model) {
        logger.info("user");
        User user = new User("aa", 11);

        List<User> list = new ArrayList<User>();
        User user1 = new User("xx", 11);
        User user2 = new User("yy", 22);
        User user3 = new User("zz", 33);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        model.addAttribute("user", user);
        model.addAttribute("users", list);

        return "index";
    }

    @RequestMapping("listUser")
    @ResponseBody
    public List<User> listUser() {
        List<User> list = userService.listUser();
        return list;
    }

}
