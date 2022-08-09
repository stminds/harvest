package com.stminds.designpattern.factory.common;

import com.stminds.designpattern.factory.abstracts.PackageAFactory;
import com.stminds.designpattern.factory.abstracts.PackageBFactory;

/**
 * 定义套餐组装工厂集合
 * @author harvest
 */
public enum Packages {
    //套餐A
    PACKAGE_A(PackageAFactory.class.getName()),
    //套餐B
    PACKAGE_B(PackageBFactory.class.getName()),
    ;

    private final String className;
    public String getClassName() {
        return className;
    }
    Packages(String name) {
        className = name;
    }
}
