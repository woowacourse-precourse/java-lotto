package lotto.model;

import static lotto.model.Constants.MONEY_MIN_UNIT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Changer {

    public static int moneyToQuantityChanger(int money) {
        return money/ MONEY_MIN_UNIT;
    }

    static List<Integer> StringToIntegers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
