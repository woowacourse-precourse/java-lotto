package lotto.uitls;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> convertToIntegerList(String input) {
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
