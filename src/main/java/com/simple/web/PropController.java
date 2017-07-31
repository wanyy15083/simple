package com.simple.web;

import com.simple.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songyigui on 2017/7/31.
 */
@RestController
public class PropController {
    @Value("${book.author}")
    private String author;
    @Value("${book.name}")
    private String name;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/book")
    public String getBook() {
//        return "book name is:" + name + "and book author is:" + author;
        return "book name is:" + authorSettings.getName() + ",and book author is:" + authorSettings.getAuthor();
    }
}
