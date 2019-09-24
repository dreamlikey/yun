package com.wdq.yun.gateway.service;

import com.wdq.yun.gateway.domain.GatewayRoute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description: TODO
 */
@Service
public class GatewayRouteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void create(GatewayRoute gatewayRoute) {
//        JdbcTemplate jdbcTemplate = dataSource.getJdbcTemplate();
        String sql = "INSERT INTO `config`.`gateway_route`(`routeId`, `order`, `uri`, `predicates`, `filters`, `routeStatus`, `lastUpdateTime`, `createTime`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] objs = {gatewayRoute.getRouteId(),gatewayRoute.getOrder(),
            gatewayRoute.getUri(),gatewayRoute.getPredicates(),gatewayRoute.getFilters(),
            gatewayRoute.getRouteStatus(),gatewayRoute.getLastUpdateTime(),gatewayRoute.getCreateTime()};
        jdbcTemplate.update(sql, objs);
    }


    public GatewayRoute getGatewayRouteById(Long id) {
        String sql = "select * from gateway_route where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<GatewayRoute>(GatewayRoute.class));
    }
}
