package com.wdq.yun.shop.service.impl;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wudq
 * @date 2019/9/10
 * @Description: TODO
 */
@Slf4j
@Component
public class ShopServiceTxTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ShopService shopService;

    @PostConstruct
    public void initAnnotationTx() {
        ShopServiceTxTest test = context.getBean(ShopServiceTxTest.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    ((ShopServiceTxTest)AopContext.currentProxy()).updateByAnnotationTx();
                    test.updateByAnnotationTx();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void initProgramTx() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    updateByProgramTx();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateByAnnotationTx() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("---------- main transaction name is:{}.", txName);
        Shop shop = new Shop();
        shop.setId(2L);
        shop.setShopName("测试声明式事务");
        shopService.update(shop);
        return 1;
//        throw new RuntimeException();
    }

    public void updateByProgramTx() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----------main transaction name is:{}.", txName);
        Shop shop = new Shop();
        shop.setId(3L);
        shop.setShopName("测试编程式事务");
        shopService.update(shop);
        throw new RuntimeException();
    }

    public void afterUpdate() {
        throw new RuntimeException();
    }
}
