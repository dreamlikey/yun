package com.wdq.yun.shop.fallback;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.api.client.ShopClient;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wudq
 * @date 2019/2/13
 * @Description: TODO
 */
@Component
public class ShopClientFallback implements ShopClient {
    @Override
    public void save(Shop shop) {

    }

    @Override
    public Shop getById(long id) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("=====执行到了fallback方法=======");
        Shop shop = new Shop();
        shop.setShopName("默认店");
        return shop;
    }

    @Override
    public List<Shop> listAll() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("=====执行到了list fallback方法=======");
        return null;
    }

    @Override
    public void checkShop(Long id) {

    }

    @Override
    public Long update(Shop shop) {
        return null;
    }
}
