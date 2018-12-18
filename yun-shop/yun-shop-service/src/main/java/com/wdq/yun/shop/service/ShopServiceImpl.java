package com.wdq.yun.shop.service;

import com.wdq.yun.domain.shop.Shop;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wudq
 * 2018/12/18
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Override
    public Shop getById(long id) {
        Shop shop = new Shop();
        shop.setShopName("Nike专卖店");
        shop.setLevel("10");
        shop.setShopNo("C01");
        shop.setDesc("Nike服饰官方商店");
        return shop;
    }
}
