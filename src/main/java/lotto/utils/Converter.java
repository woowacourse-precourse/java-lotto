package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static int moneyToTicket(int money) {
        return money / 1000;
    }

    public static List<Integer> stringToList(String stringLiteral) {
        String[] splintedNumbers = stringLiteral.split(",");
        return Arrays.stream(splintedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int stringToNumber(String stringLiteral) {
        return Integer.parseInt(stringLiteral);
    }
}
