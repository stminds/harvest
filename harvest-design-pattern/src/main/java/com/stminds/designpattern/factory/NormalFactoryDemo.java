package com.stminds.designpattern.factory;

import com.stminds.designpattern.factory.common.Products;
import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.normal.BenchFactory;

/**
 * @author harvest
 */
public class NormalFactoryDemo {
    public static void main(String[] args) {
        {
            Bench stoneBench = BenchFactory.getBench(Products.STONE_BENCH);
            stoneBench.desc();
            Bench woodBench = BenchFactory.getBench(Products.WOOD_BENCH);
            woodBench.desc();
        }
        {
            Bench stoneBench = BenchFactory.getDynamicBench(Products.STONE_BENCH);
            stoneBench.desc();
            Bench woodBench = BenchFactory.getDynamicBench(Products.WOOD_BENCH);
            woodBench.desc();
            Bench benchBed = BenchFactory.getDynamicBench(Products.BAMBOO_BENCH);
            benchBed.desc();
        }
    }
}

