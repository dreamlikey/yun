package com.wdq.yun.common.interfaces;

import java.io.*;

/**
 * @author wudq
 *
 */
public interface BaseService<PK, Entity extends Serializable> {
//    CRUD
    void save(Entity t);

    Entity get(PK id);

    PK update(Entity t);

    void delete(PK id);
}
