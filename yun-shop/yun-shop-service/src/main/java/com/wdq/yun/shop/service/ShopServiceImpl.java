package com.wdq.yun.shop.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wdq.yun.common.interfaces.BaseServiceImpl;
import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.dao.ShopDao;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author wudq
 * 2018/12/18
 */
@RestController(value = "shopService")
public class ShopServiceImpl extends BaseServiceImpl<Long, Shop, ShopDao> implements ShopService {

    @Autowired
    public void setEntityDao(ShopDao shopDao) {
        this.entityDao = shopDao;
    }

    @HystrixCommand(fallbackMethod="saveFallback")
    @Override
    public void save(@RequestBody Shop shop) {
        shop.setCreateTime(new Date());
        this.entityDao.save(shop);
        System.out.println("保存成功："+shop.toString());
    }

    @Override
    public Shop getById(long id) {
        Shop shop = new Shop();
        shop.setShopName("Nike专卖店");
        shop.setLevel("10");
        shop.setShopNo("C01");
        shop.setdescription("Nike服饰官方商店");
        return shop;
    }

    @Override
    public List<Shop> listAll() {
        return this.entityDao.listAll();
    }

    @Override
    public void checkShop(Long id) {
    }

    @Transactional
    @Override
    public Long update(@RequestBody Shop shop) {
        System.out.println(shop.toString());
        return null;
    }

    @HystrixCommand
    private void saveFallback(Shop shop) {
        throw new RuntimeException("save failed!");
    }
}
