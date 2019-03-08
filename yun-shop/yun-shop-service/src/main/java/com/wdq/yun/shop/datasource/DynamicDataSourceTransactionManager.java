package com.wdq.yun.shop.datasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import javax.sql.DataSource;

/**
 * @author wudq
 * @date 2019/3/8
 * @Description: TODO
 */
public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager {
    public DynamicDataSourceTransactionManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        super.doBegin(transaction, definition);
    }

    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        DynamicDataSourceHolder.clearDataSource();
        super.doCleanupAfterCompletion(transaction);
    }
}
