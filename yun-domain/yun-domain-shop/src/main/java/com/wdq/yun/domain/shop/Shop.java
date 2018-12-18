package com.wdq.yun.domain.shop;

/**
 * 商铺实体
 * 2018/12/18
 *
 */
public class Shop {
    private Long id;

    private String shopName;

    private String shopNo;

    private String level;

    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Shop{" +
            "id=" + id +
            ", shopName='" + shopName + '\'' +
            ", shopNo='" + shopNo + '\'' +
            ", level='" + level + '\'' +
            ", desc='" + desc + '\'' +
            '}';
    }
}
