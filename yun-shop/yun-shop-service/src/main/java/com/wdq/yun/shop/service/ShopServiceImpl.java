package com.wdq.yun.shop.service;

import com.wdq.yun.common.interfaces.BaseServiceImpl;
import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.dao.ShopDao;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wudq
 * 2018/12/18
 */
@Service
public class ShopServiceImpl extends BaseServiceImpl<Long, Shop, ShopDao<Long,Shop>> implements ShopService {

    @Autowired
    public void setEntityDao(ShopDao shopDao) {
        this.entityDao = shopDao;
    }

    @Override
    @Transactional
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
}
