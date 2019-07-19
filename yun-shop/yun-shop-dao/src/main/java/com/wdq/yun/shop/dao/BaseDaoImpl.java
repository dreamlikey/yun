package com.wdq.yun.shop.dao;

import com.wdq.yun.common.annotation.DataSource;
import com.wdq.yun.common.constant.DynamicDataSourceGlobal;
import com.wdq.yun.common.dao.BaseDao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wudq
 * @date 2018/12/19 10:30
 * @Description: 公共持久层实现
 */
@Repository
public class BaseDaoImpl<PK, Entity> extends SqlSessionDaoSupport implements BaseDao<Long,Entity> {

    private Class<Entity> entityClass;

    public BaseDaoImpl() {
        Class clazz = getClass();
        Type genType = clazz.getGenericSuperclass();
        //获取泛型Entity的Class
        if(genType instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
            entityClass = (Class) types[1];
        }
    }

    /**
     * 初始化创建sqlSession的factory
     * @param sqlSessionFactory
     */
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @DataSource(DynamicDataSourceGlobal.WRITE)
    @Override
    public void save(Entity entity) {
        this.getSqlSession().insert(getStatement(MAPPER_SAVE), entity);
    }

    @DataSource(DynamicDataSourceGlobal.WRITE)
    @Override
    public Entity get(Long id) {
        return this.getSqlSession().selectOne(getStatement(MAPPER_GET), id);
    }

    @Override
    public Long update(Entity entity) {
        return Long.valueOf(this.getSqlSession().update(getStatement(MAPPER_UPDATE),entity));
    }

    @Override
    public void delete(Long id) {
        this.getSqlSession().delete(getStatement(MAPPER_DELETE), id);
    }

    @Override
    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    /**
     * 获取要调用的mapper的声明
     * @param mapper
     * @return
     */
    public String getStatement(String mapper) {
        return entityClass.getName()+ "." + mapper;
    }
}
