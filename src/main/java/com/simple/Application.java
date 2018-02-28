package com.simple;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by songyigui on 2016/10/17.
 */

//@EnableAutoConfiguration
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan
//@EnableWebMvc
@Configuration
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.simple.mapper")
//@ImportResource({"classpath:spring/spring-config.xml"})
public class Application extends SpringBootServletInitializer {
    private static Logger logger = Logger.getLogger(Application.class);

    //DataSource配置
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }

    //提供SqlSession
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
//        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    //JSP View Resolver
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/classes/views/");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        return viewResolver;
//    }

    //Template Resolver
//    @Bean
//    public TemplateResolver templateResolver() {
//        TemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        return templateResolver;
//    }

    //Template Engine
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }

    //Thymeleaf View Resolver
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
////        thymeleafViewResolver.setViewClass(ThymeleafView.class);
//        return thymeleafViewResolver;
//    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * main start
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("========== SpringBoot Start Success ==========");
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
