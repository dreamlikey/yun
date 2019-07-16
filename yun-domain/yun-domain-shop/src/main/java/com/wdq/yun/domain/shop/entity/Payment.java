package com.wdq.yun.domain.shop.entity;

import java.util.Date;

/**
 * @author wudq
 * @date 2019/7/12
 * @Description: TODO
 */
public class Payment {
    private Double amount;
    private String carNo;
    private Date payTime;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "Payment{" +
            "amount=" + amount +
            ", carNo='" + carNo + '\'' +
            ", payTime=" + payTime +
            '}';
    }
}
