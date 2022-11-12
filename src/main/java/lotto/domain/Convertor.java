package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final int eachPrice = 1000;

    public static int getQuantity(String input) {
        return Integer.parseInt(input) / eachPrice;
    }

    public static int getAmount(int quantity) {
        return (quantity * eachPrice);
    }

    public static List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getNumber(String input) {
        return Integer.parseInt(input);
    }
}
