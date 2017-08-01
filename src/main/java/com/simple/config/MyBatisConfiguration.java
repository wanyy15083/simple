package com.simple.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Created by songyigui on 2017/7/31.
 */
//@Configuration
public class MyBatisConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

    @Bean
    public PageHelper pageHelper() {
        logger.info("======register pageHelper=====");
        PageHelper pageHelper = new PageHelper();
        Properties prop = new Properties();
        prop.setProperty("helperDialect", "mysql");
        prop.setProperty("supportMethodsArguments", "true");
        prop.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(prop);
        return pageHelper;
    }
}
