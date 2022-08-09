package com.stminds.designpattern.factory.common;

import com.stminds.designpattern.factory.product.bench.BambooBench;
import com.stminds.designpattern.factory.product.bench.StoneBench;
import com.stminds.designpattern.factory.product.bench.WoodBench;
import com.stminds.designpattern.factory.product.desk.StoneDesk;
import com.stminds.designpattern.factory.product.desk.WoodDesk;

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
    BAMBOO_BENCH(BambooBench.class.getName()),

    //木桌子
    WOOD_CHAIR(WoodDesk.class.getName()),
    //石桌子
    STONE_CHAIR(StoneDesk.class.getName()),
    ;

    private final String className;
    public String getClassName() {
        return className;
    }
    Products(String name) {
        className = name;
    }
}
