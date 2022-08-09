package com.stminds.designpattern.factory.abstracts;

import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.product.Desk;
import com.stminds.designpattern.factory.product.bench.WoodBench;
import com.stminds.designpattern.factory.product.desk.WoodDesk;

/**
 * 套餐B工厂
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-09 22:24
 */
public class PackageBFactory implements AbstractFactory {

    @Override
    public Desk createDesk() {
        return new WoodDesk();
    }

    @Override
    public Bench createBench() {
        return new WoodBench();
    }
}
