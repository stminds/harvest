package com.stminds.designpattern.factory;

import com.stminds.designpattern.factory.abstracts.AbstractFactory;
import com.stminds.designpattern.factory.common.Packages;
import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.product.Desk;

/**
 * 抽象工厂
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-09 21:51
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        //客户选择了A套餐工厂
        AbstractFactory factory = AbstractFactory.createFactory(Packages.PACKAGE_A);
        //得到一个桌子
        Desk desk = factory.createDesk();
        desk.desc();

        //得到一个凳子
        Bench bench = factory.createBench();
        bench.desc();
    }

}
