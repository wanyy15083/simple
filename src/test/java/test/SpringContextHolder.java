package test;

import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

/** 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext. * */
@Service()
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;

    /** 实现ApplicationContextAware接口, 注入Context到静态变量中. */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringContextHolder.applicationContext != null) {
            System.out.println("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + SpringContextHolder.applicationContext);
        }
        System.out.println("Spring容器启动，将容器实例注入到SpringContextHolder实例bean中");
        SpringContextHolder.applicationContext = applicationContext;
    }

    /** 实现DisposableBean接口,重写destroy方法,相当于destroy-method,bean被销毁的时候被调用, * 实现在Context关闭时清理静态变量的目的 * 令：还有InitializingBean接口，重写afterPropertiesSet方法，相当于init-method，bean被实例化的时候被调用 */
    @Override
    public void destroy() throws Exception {
        applicationContext = null;
    }

    /** 取得存储在静态变量中的ApplicationContext. */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /** 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型. */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /** 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型. */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }
}