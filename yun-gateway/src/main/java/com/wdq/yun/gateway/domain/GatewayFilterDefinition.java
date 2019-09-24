package com.wdq.yun.gateway.domain;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description: TODO
 */
public class GatewayFilterDefinition implements Serializable {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
