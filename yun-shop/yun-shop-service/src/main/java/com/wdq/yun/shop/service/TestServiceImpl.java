package com.wdq.yun.shop.service;

import com.wdq.yun.common.interfaces.BaseServiceImpl;
import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.dao.ShopDao;
import com.wdq.yun.shop.interfaces.ShopService;
import com.wdq.yun.shop.interfaces.TestService;

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
@RestController
public class TestServiceImpl extends BaseServiceImpl<Long, Shop, ShopDao> implements TestService {

    @Autowired
    @Override
    public void setEntityDao(ShopDao shopDao) {
        this.entityDao = shopDao;
    }

    @Override
    public String test() {
        return "success";
    }
}
