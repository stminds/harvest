package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class StoneFactory {
    
    public static Stone getStone(Products product) {
        if (product == Products.STONE_BENCH) {
            return new StoneBench();
        }
        if (product == Products.STONE_TABLE) {
            return new StoneTable();
        }
        throw new IllegalArgumentException("产品无法生产");
    }
    
    public static Stone getDynamicStone(Products product) {
        try {
            Object obj = Class.forName(product.getClassName()).newInstance();
            return (Stone) obj;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("产品无法生产");
    }
}
