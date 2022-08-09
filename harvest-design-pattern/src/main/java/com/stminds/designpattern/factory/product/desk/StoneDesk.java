package com.stminds.designpattern.factory.product.desk;

import com.stminds.designpattern.factory.product.Desk;

/**
 * @author harvest
 */
public class StoneDesk implements Desk {
    @Override
    public void desc() {
        System.out.println("我是石桌");
    }
}
