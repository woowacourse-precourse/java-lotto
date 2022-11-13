package lotto.utils;

import static lotto.utils.Validation.validateIsNumber;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static int stringToInt(String target) {
        validateIsNumber(target);
        return Integer.parseInt(target);
    }

    public static List<Integer> stringToIngerListByComma(String input) {
        List<Integer> returns = new ArrayList<>();
        String[] split = input.split(",");
        for (String number : split) {
            returns.add(stringToInt(number));
        }
        return returns;
    }
}
