package com.wdq.yun.domain.shop.entity;

import java.io.*;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 商铺实体
 * 2018/12/18
 * @author wudq
 */
@Entity(name = "shop")
public class Shop implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String shopName;

    private String shopNo;

    /**商品等级 */
    private String level;

    /**店主id */
    private Long ownerId;

    /**店主名 */
    private String ownerName;

    /**商品类型 */
    private int type;

    /**商品状态 */
    private int status;

    private String description;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shop{" +
            "id=" + id +
            ", shopName='" + shopName + '\'' +
            ", shopNo='" + shopNo + '\'' +
            ", level='" + level + '\'' +
            ", ownerId=" + ownerId +
            ", ownerName='" + ownerName + '\'' +
            ", type='" + type + '\'' +
            ", status=" + status +
            ", description='" + description + '\'' +
            ", createTime=" + createTime +
            '}';
    }

}
