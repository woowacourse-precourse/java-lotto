package lotto.domain;

import lotto.UI.ErrorMessage;

import java.util.Arrays;
import java.util.function.Predicate;

public class TargetNumbers {
    private TargetNumbers(String input) {
        isInputFormValid(input);

    }

    public static TargetNumbers getInstance(String input) {
        return new TargetNumbers(input);
    }

    private void isInputFormValid(String input) throws IllegalArgumentException {

    }
}
