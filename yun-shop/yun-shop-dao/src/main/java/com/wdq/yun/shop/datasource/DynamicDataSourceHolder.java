package com.wdq.yun.shop.datasource;

import com.wdq.yun.common.constant.DataSourceGlobal;

/**
 * @author wudq
 * @date 2019/3/4 000414
 * @Description: TODO
 */
public class DynamicDataSourceHolder {
    public static ThreadLocal<DataSourceGlobal> holder = new ThreadLocal();


    public void setDataSource(DataSourceGlobal dataSource) {
        holder.set(dataSource);
    }

    public void getDataSource(DataSourceGlobal dataSource) {
        holder.get();
    }

    public void clearDataSource() {
        holder.remove();
    }
}
