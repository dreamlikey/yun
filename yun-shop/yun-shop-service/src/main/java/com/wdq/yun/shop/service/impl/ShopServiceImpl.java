package com.wdq.yun.shop.service.impl;

import com.wdq.yun.common.interfaces.BaseServiceImpl;
import com.wdq.yun.component.exception.BusinessException;
import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.service.client.SyncPaymentClient;
import com.wdq.yun.shop.dao.ShopDao;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wudq
 * 2018/12/18
 */
@Slf4j
@RestController
public class ShopServiceImpl extends BaseServiceImpl<Long, Shop, ShopDao> implements ShopService {

    @Autowired
    private SyncPaymentClient syncPaymentClient;

    @Autowired
    @Override
    public void setEntityDao(ShopDao shopDao) {
        this.entityDao = shopDao;
    }

    @Override
    public void save(@RequestBody Shop shop) {
        shop.setCreateTime(new Date());
        this.entityDao.save(shop);
        System.out.println("保存成功："+shop.toString());
    }

    @Override
    public Shop getById(long id) {
        String s = null;
        s.replace("123", "456");
        log.info("获取商铺：{}",id);
        int i = 1/0;
        if (id==1) {
            throw new BusinessException(-1,"业务异常了大佬");
        }
        return this.entityDao.get(id);
    }

    @Override
    public List<Shop> listAll() {
        List<Shop> list = this.entityDao.listAll();
        return list;
    }

    @Override
    public void checkShop(Long id) {
    }

    @Transactional
    @Override
    public Long update(@RequestBody Shop shop) {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("---------- transaction name is:{}.", txName);
        System.out.println(shop.toString());
        this.entityDao.update(shop);
        return 1L;
    }

    @Override
    public Shop test() {
        Shop shop = new Shop();
        shop.setShopName("Nike专卖店");
        shop.setLevel("10");
        shop.setShopNo("C01");
        shop.setdescription("Nike服饰官方商店");
        return shop;
    }

    @Override
    public void payByAlipay(double amount) {
        int count = 1;
        while(count < 10000) {
            System.out.println("支付："+count);
            syncPaymentClient.aliPayEvent(count);
            count++;
        }
    }

    public void payByWechatPay(double amount) {
        syncPaymentClient.wechatPayEvent(1);
    }

}
