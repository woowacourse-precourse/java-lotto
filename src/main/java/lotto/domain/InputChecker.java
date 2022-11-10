package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.Constants.*;

public class InputChecker {
    public void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }

    public void validateWinningNumbers(String input) {
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            validateNumeric(piece);
        }
    }

    private List<String> splitInput(String input) {
        String[] splitForm = input.split(",");
        return Arrays.asList(splitForm);
    }
}
