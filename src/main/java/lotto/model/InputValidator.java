package lotto.model;

import static lotto.model.Changer.StringToIntegers;

import java.util.List;

class InputValidator {
    public static void isValid(String input) {
        List<Integer> list = StringToIntegers(input);
        NumbersValidator.isValid(list);
    }

}
