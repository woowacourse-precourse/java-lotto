package lotto.utils;

import static lotto.utils.Constants.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> convertToIntegerList(String input) {
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int convertToCountsOfLotto(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }
}
