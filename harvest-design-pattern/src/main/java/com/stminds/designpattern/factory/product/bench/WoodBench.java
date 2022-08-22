package com.stminds.designpattern.factory.product.bench;

import com.stminds.designpattern.factory.product.Bench;
import com.stminds.designpattern.prototype.AbstractBench;

/**
 * @author harvest
 */
public class WoodBench extends AbstractBench implements Bench {

    @Override
    public void desc() {
        System.out.println("我是木凳");
    }
}
