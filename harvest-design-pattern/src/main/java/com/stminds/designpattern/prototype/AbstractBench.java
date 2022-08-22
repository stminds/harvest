package com.stminds.designpattern.prototype;

/**
 * @author harvest
 */
public abstract class AbstractBench implements Cloneable {
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
