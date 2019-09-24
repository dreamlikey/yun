package com.wdq.yun.gateway.domain;
import java.io.*;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description:
 */
@Data
public class GatewayRoute implements Serializable {
    private Long id;
    private String routeId;
    private String uri;
    private Integer order;
    private List<GatewayPredicateDefinition> predicates;
    private List<GatewayFilterDefinition> filters;
    private Integer routeStatus;
    private Date lastUpdateTime;
    private Date createTime;

}
