package com.wdq.yun.shop.interfaces;

import com.wdq.yun.common.interfaces.BaseService;
import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 2018/12/18
 */
@RequestMapping("shop-service")
public interface ShopService extends BaseService<Long, Shop>{

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Shop getById(long id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Shop> listAll();
}
