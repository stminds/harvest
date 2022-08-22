package com.stminds.designpattern.prototype;

import com.stminds.designpattern.factory.common.Products;
import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.product.bench.BambooBench;
import com.stminds.designpattern.factory.product.bench.StoneBench;
import com.stminds.designpattern.factory.product.bench.WoodBench;

import java.util.EnumMap;
import java.util.Map;

/**
 * 原型模式，浅克隆
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-21 21:16
 */
public class ShallowClone implements Cloneable{
    private static final Map<Products, AbstractBench> BENCH_MAP = new EnumMap<>(Products.class);
    public static void init() {
        BambooBench bambooBench = new BambooBench();
        StoneBench stoneBench = new StoneBench();
        WoodBench woodBench = new WoodBench();
        BENCH_MAP.put(Products.BAMBOO_BENCH, bambooBench);
        BENCH_MAP.put(Products.STONE_BENCH, stoneBench);
        BENCH_MAP.put(Products.WOOD_BENCH, woodBench);
    }

    public static Bench get(Products product) {
        AbstractBench bench = BENCH_MAP.get(product);
        Object clones = bench.clone();
        return (Bench) clones;
    }

    public static void main(String[] args) {
        ShallowClone.init();
        Bench bench = ShallowClone.get(Products.BAMBOO_BENCH);
        bench.desc();
    }
}
