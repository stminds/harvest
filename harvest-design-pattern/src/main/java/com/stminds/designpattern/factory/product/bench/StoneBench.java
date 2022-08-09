package com.stminds.designpattern.factory.product.bench;

import com.stminds.designpattern.factory.product.Bench;

/**
 * @author harvest
 */
public class StoneBench implements Bench {
    @Override
    public void desc() {
        System.out.println("我是石凳");
    }
}
