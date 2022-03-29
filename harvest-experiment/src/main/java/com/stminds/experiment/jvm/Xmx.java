package com.stminds.experiment.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx20m
 *
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3210)
 * 	at java.util.Arrays.copyOf(Arrays.java:3181)
 * 	at java.util.ArrayList.grow(ArrayList.java:267)
 * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:241)
 * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:233)
 * 	at java.util.ArrayList.add(ArrayList.java:464)
 * 	at com.stminds.experiment.jvm.Xmx.main(Xmx.java:17)
 *
 *
 * @author harvest
 * @version 1.0
 * @date 2022-01-15 12:50
 */
public class Xmx {
    public static void main(String[] args) {
        List<Xmx> list = new ArrayList<>();
        while (true) {
            list.add(new Xmx());
        }
    }
}
