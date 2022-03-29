package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class WoodBench implements Bench {
    @Override
    public void desc() {
        System.out.println("我是木凳");
    }
}
