package com.wdq.yun.shop.datasource;

import com.wdq.yun.common.constant.DynamicDataSourceGlobal;

/**
 * @author wudq
 * @date 2019/3/4 000414
 * @Description: TODO
 */
public class DynamicDataSourceHolder {
    public static ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal();


    public static void putDataSource(DynamicDataSourceGlobal dataSource) {
        holder.set(dataSource);
    }

    public static DynamicDataSourceGlobal getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }
}
