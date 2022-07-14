package com.stminds.experiment.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1).filter(integer -> false);
        Stream<String> generate = Stream.generate(() -> "1");
        Stream<Integer> iterate = Stream.iterate(0, a -> a + 1);
        Stream.generate(() -> "1").collect(Collectors.toMap(key -> key, v -> v, (r1, r2) -> r1));
    }

}
