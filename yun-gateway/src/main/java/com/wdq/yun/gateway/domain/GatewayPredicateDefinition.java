package com.wdq.yun.gateway.domain;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description: TODO
 */
@Data
public class GatewayPredicateDefinition implements Serializable {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
