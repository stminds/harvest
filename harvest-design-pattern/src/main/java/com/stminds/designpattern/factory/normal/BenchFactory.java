package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class BenchFactory {
    
    public static Bench getBench(Products product) {
        if (product == Products.STONE_BENCH) {
            return new StoneBench();
        }
        if (product == Products.WOOD_BENCH) {
            return new WoodBench();
        }
        throw new IllegalArgumentException("产品无法生产");
    }
    
    public static Bench getDynamicBench(Products product) {
        try {
            Object obj = Class.forName(product.getClassName()).newInstance();
            return (Bench) obj;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("产品无法生产");
    }
}
