package com.stminds.designpattern.builder;

/**
 * TODO
 *
 * @author harvest
 * @version 1.0
 * @date 2022-08-16 22:49
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        //构建过程，可多次调用
        stringBuilder.append("123");
        stringBuilder.insert(0, 456);
        //构建过程，可自身调用
        stringBuilder.append(789).append(10);
        //这里的toString即为通常的.build()方法
        String s = stringBuilder.toString();
        System.out.println(s);
    }

}
