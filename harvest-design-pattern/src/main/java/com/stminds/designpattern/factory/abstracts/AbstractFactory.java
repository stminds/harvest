package com.stminds.designpattern.factory.abstracts;

import com.stminds.designpattern.factory.common.Packages;
import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.factory.product.Desk;

/**
 * 抽象工厂，可以使用抽象类代替
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-09 22:08
 */
public interface AbstractFactory {

    Desk createDesk();

    Bench createBench();

    /**
     * 根据参数选择工厂,封装创建细节，感觉整合了工厂模式
     */
    static AbstractFactory createFactory(Packages pkg) {
        if (pkg == Packages.PACKAGE_A) {
            return new PackageAFactory();
        } else if (pkg == Packages.PACKAGE_B) {
            return new PackageBFactory();
        }
        throw new IllegalArgumentException("Invalid factory name");
    }

}
