package com.simple.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by songyigui on 2017/7/31.
 */
@Component
@ConfigurationProperties(prefix = "book")
//@ConfigurationProperties(prefix = "author",locations = "classpath:properties/author.properties")
public class AuthorSettings {
    private String author;
    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
