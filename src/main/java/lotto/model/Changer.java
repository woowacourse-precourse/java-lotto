package lotto.model;

import static lotto.model.Constants.MONEY_MIN_UNIT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Changer {

    public static final String INPUT_TARGET_LOTTO_DELIMITER = ",";

    public static int moneyToQuantityChanger(int money) {
        return money / MONEY_MIN_UNIT;
    }

    public static List<Integer> stringToIntegers(String input) {
        return Arrays.stream(input.split(INPUT_TARGET_LOTTO_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
