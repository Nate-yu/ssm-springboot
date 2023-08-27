package com.hut.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) // 单例
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 多例
@Component
public class JavaBean {

    @PostConstruct
    public void init() {
        System.out.println("JavaBean init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean destroy...");
    }
}
