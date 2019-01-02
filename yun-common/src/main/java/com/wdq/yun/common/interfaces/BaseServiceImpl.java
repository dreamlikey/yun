package com.wdq.yun.common.interfaces;

import com.wdq.yun.common.dao.BaseDao;

import org.springframework.transaction.annotation.Transactional;

import java.io.*;

import javax.annotation.Resource;

/**
 * @author wudq
 * 2018/12/19
 */
public abstract class BaseServiceImpl<PK, Entity extends Serializable, EntityDao extends BaseDao<PK, Entity>> implements BaseService<PK, Entity>{


    protected EntityDao entityDao;

    protected EntityDao getEntityDao() {
        return this.entityDao;
    }

    public abstract void setEntityDao(EntityDao entityDao);

    @Override
    @Transactional
    public void save(Entity entity) {
        this.getEntityDao().save(entity);
    }

    @Override
    public Entity get(PK id) {
        return null;
    }

    @Override
    @Transactional
    public PK update(Entity t) {
        System.out.println(t.toString());
        return null;
    }

    @Override
    public void delete(PK id) {

    }
}
