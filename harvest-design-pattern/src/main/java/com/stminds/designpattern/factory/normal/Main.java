package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class Main {
    public static void main(String[] args) {
        Stone stoneBench = StoneFactory.getStone(StoneFactory.Products.STONE_BENCH);
        stoneBench.desc();
        Stone stoneTable = StoneFactory.getStone(StoneFactory.Products.STONE_TABLE);
        stoneTable.desc();
    }
}

