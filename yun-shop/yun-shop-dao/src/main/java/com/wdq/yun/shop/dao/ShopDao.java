package com.wdq.yun.shop.dao;

import com.wdq.yun.common.dao.BaseDao;
import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiachao
 * @date 2018/12/19
 * @Description: TODO
 */
public interface ShopDao extends BaseDao<Long, Shop> {
    List<Shop> listAll();
}
