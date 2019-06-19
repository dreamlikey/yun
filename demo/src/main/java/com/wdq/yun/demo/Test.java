package com.wdq.yun.demo;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2019/2/21 002110
 * @Description: TODO
 */
public class Test implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }




    private Long m = 0L;

    public void set1() {
        m = 0L;
    }

    public void set2() {
        m = -1L;
    }

    public void check() {
        System.out.println(m);
        if (m !=0 && m != -1) {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.set1();
        test.set2();
        test.check();
    }
}
