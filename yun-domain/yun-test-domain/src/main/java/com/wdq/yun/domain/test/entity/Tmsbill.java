package com.wdq.yun.domain.test.entity;

import java.io.*;
import java.util.Date;

import lombok.Data;

/**
 *  tmsbill
 * @author wudq
 * 2019-09-24
 */
@Data
public class Tmsbill implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private String id;

    /**
     * LIKE关键字
     */
    private String keywords;

    /**
     * 父运单Id
     */
    private String parentId;

    /**
     * 父运单号
     */
    private String parentNo;

    /**
     * 运单Id
     */
    private String waybillId;

    /**
     * 运单唯一编号
     */
    private String waybillNo;

    /**
     * 第三方单号:磅单号
     */
    private String thirdNo;

    /**
     * 出发地
     */
    private String departureCity;

    /**
     * 目的地
     */
    private String arrivalCity;

    /**
     * 货物类型
     */
    private String cargoType;

    /**
     * 货物数量
     */
    private String cargoNum;

    /**
     * 运费总额（成本）
     */
    private String freightAmount;

    /**
     * 运单车辆Id
     */
    private String waybillCarId;

    /**
     * 项目Id
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 计划Id
     */
    private String programId;

    /**
     * 计划名称
     */
    private String programName;

    /**
     * 派车人Id，0=自动派车
     */
    private String operationUserId;

    /**
     * 驾驶员Id
     */
    private String driverId;

    /**
     * 驾驶员姓名
     */
    private String driverName;

    /**
     * 驾驶员手机号
     */
    private String driverMobileNo;

    /**
     * 车辆Id
     */
    private String vehicleId;

    /**
     * 车牌号
     */
    private String licensePlateNo;

    /**
     * 车主Id
     */
    private String vehicleOwnerId;

    /**
     * 车主类型：1=个体，2=物流公司，3=虚拟个体，4=虚拟物流公司
     */
    private String vehicleOwnerType;

    /**
     * 承运主体：0=个人，非0为物流公司Id
     */
    private String logisticId;

    /**
     * 发票Id
     */
    private String invoiceId;

    /**
     * 受票方名称
     */
    private String draweeName;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 运输状态：1=待装车，2=运输中，3=运输完成，9=已关闭
     */
    private String runningStatus;

    /**
     * 运单异常状态 0-正常 1-异常
     */
    private String exceptionStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 装货时间
     */
    private Date loadingTime;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 单据通过时间
     */
    private Date billPassTime;

    /**
     * 承运方支付运费时间
     */
    private String payFreightTime;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    public Tmsbill() {
    }

}
