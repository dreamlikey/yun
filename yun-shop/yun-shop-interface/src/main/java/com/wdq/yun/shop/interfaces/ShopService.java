package com.wdq.yun.shop.interfaces;

import com.wdq.yun.common.interfaces.BaseService;
import com.wdq.yun.domain.shop.entity.Shop;

import java.util.List;

/**
 * 2018/12/18
 */
public interface ShopService extends BaseService<Long, Shop>{
    Shop getById(long id);

    List<Shop> listAll();
}
