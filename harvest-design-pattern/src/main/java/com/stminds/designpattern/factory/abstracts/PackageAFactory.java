package com.stminds.designpattern.factory.abstracts;

import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.product.Desk;
import com.stminds.designpattern.factory.product.bench.StoneBench;
import com.stminds.designpattern.factory.product.desk.StoneDesk;

/**
 * 套餐A工厂
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-09 22:24
 */
public class PackageAFactory implements AbstractFactory {

    @Override
    public Desk createDesk() {
        return new StoneDesk();
    }

    @Override
    public Bench createBench() {
        return new StoneBench();
    }
}
