package com.wdq.yun.shop.dao;

import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wudq
 * @date 2018/12/19 001910
 * @Description: TODO
 */
@Repository
public class ShopDaoImpl extends BaseDaoImpl<Long, Shop> implements ShopDao{

    @Override
    public List<Shop> listAll() {
        return this.getSqlSession().selectList(getStatement("listAll"),null);
    }
}
