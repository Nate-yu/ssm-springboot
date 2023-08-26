package com.hut.ioc_04;

public class JavaBean {

    /**
     * 方法必须是public void，且必须是是无参数
     * 方法名随意
     */
    public void init() {
        System.out.println("JavaBean init");
    }

    /**
     * 销毁方法
     */
    public void clear() {
        System.out.println("JavaBean clear");
    }
}
