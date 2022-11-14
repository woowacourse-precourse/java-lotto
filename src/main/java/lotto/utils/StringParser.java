package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<Integer> stringToIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
