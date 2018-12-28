package com.wdq.yun.common.dao;

/**
 * @author wudq
 * 2018/12/19
 * 修改操作添加事物
 */
public interface BaseDao<PK, Entity> {

    static String MAPPER_SAVE = "save";
    static String MAPPER_UPDATE = "update";
    static String MAPPER_DELETE = "delete";
    static String MAPPER_GET = "get";

    void save(Entity entity);

    Entity get(PK id);

    PK update(Entity t);

    void delete(PK id);
}
