package com.stminds.designpattern.factory.normal;

/**
 * @author harvest
 */
public class Main {
    public static void main(String[] args) {
        {
            Stone stoneBench = StoneFactory.getStone(Products.STONE_BENCH);
            stoneBench.desc();
            Stone stoneTable = StoneFactory.getStone(Products.STONE_TABLE);
            stoneTable.desc();
        }
        {
            Stone stoneBench = StoneFactory.getDynamicStone(Products.STONE_BENCH);
            stoneBench.desc();
            Stone stoneTable = StoneFactory.getDynamicStone(Products.STONE_TABLE);
            stoneTable.desc();
            Stone stoneBed = StoneFactory.getDynamicStone(Products.STONE_BED);
            stoneBed.desc();
        }
    }
}

