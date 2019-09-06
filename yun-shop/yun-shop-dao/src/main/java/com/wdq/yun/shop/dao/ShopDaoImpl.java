package com.wdq.yun.shop.dao;

import com.wdq.yun.common.annotation.DataSource;
import com.wdq.yun.common.constant.DynamicDataSourceGlobal;
import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wudq
 * @date 2018/12/19
 * @Description: TODO
 */
@Repository
public class ShopDaoImpl extends BaseDaoImpl<Long, Shop> implements ShopDao{

    @DataSource(value = DynamicDataSourceGlobal.READ)
    @Override
    public List<Shop> listAll() {
        return this.getSqlSession().selectList(getStatement("listAll"),null);
    }
}
