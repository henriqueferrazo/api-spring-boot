package tech.calindra.program;

import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        var numberStr = List.of("1", "2", "3");

        var numbers = numberStr.parallelStream()
            .map(Long::valueOf)
            .map(number -> number * 2)
            .toList();

        System.out.println(numbers);
    }
}
