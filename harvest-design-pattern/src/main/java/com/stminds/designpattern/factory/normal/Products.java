package com.stminds.designpattern.factory.normal;

/**
 * 定义产品集合，我这个工厂只生产两种产品，其他的不生产
 * @author harvest
 */
public enum Products {
    //石桌
    STONE_TABLE(StoneTable.class.getName()),
    //石凳
    STONE_BENCH(StoneBench.class.getName()),
    //石床
    STONE_BED(StoneBed.class.getName());
    private final String className;
    public String getClassName() {
        return className;
    }
    Products(String name) {
        className = name;
    }
}
