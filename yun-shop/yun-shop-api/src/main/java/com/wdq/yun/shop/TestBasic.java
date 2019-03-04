package com.wdq.yun.shop;

import java.math.BigDecimal;

/**
 * @author wudq
 * @date 2019/1/9 000911
 * @Description: TODO
 */
public class TestBasic {

    private static final double  MILLS_OF_HOUR = 60 * 60 * 1000.0;
    private static final int SPEED = 600 * 1000;

    public static void main(String[] args) {
        double d = 114.145;
        BigDecimal b = new BigDecimal(1 / 11.00);
        d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);

        double runedDistance = 2959102/MILLS_OF_HOUR * SPEED / 24;
        System.out.println(2959102/MILLS_OF_HOUR );
        System.out.println(SPEED / 24.0);
        System.out.println(runedDistance);

        System.out.println(0%3);
    }
}
