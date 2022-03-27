package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class StoneFactory {
    /**
     *  定义产品集合，我这个工厂只生产两种产品，其他的不生产
     */
    enum Products{
        //石桌
        STONE_TABLE,
        //石凳
        STONE_BENCH
    }
    
    public static Stone getStone(Products product) {
        if (product == Products.STONE_BENCH) {
            return new StoneBench();
        }
        if (product == Products.STONE_TABLE) {
            return new StoneTable();
        }
        throw new IllegalArgumentException("产品无法生产");
    }
}
