package com.wdq.yun.component.datasource;

import com.wdq.yun.common.constant.DynamicDataSourceGlobal;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: TODO
 */
public class DynamicDataSourceHolder {
    /**
     * 每个线程绑定一个数据源
     */
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

    public static void write() {
        holder.set(DynamicDataSourceGlobal.WRITE);
    }

    public static void read() {
        holder.set(DynamicDataSourceGlobal.READ);
    }
}
