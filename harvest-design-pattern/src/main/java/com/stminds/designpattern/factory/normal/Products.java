package com.stminds.designpattern.factory.normal;

/**
 * 定义产品集合，我这个工厂只生产两种产品，其他的不生产
 * @author harvest
 */
public enum Products {
    //木凳
    WOOD_BENCH(WoodBench.class.getName()),
    //石凳
    STONE_BENCH(StoneBench.class.getName()),
    //竹凳
    BAMBOO_BENCH(BambooBench.class.getName());
    private final String className;
    public String getClassName() {
        return className;
    }
    Products(String name) {
        className = name;
    }
}
