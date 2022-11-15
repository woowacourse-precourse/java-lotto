package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ValidCheck {
    public static void validateLotto(List<Integer> numbers) {
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getText());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LENGTH_ERROR.getText());
        }
        HashSet<Integer> numbersWithoutDuplicate = new HashSet<>(numbers);
        if (numbersWithoutDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_ERROR.getText());
        }
    }

    public static void formatCheckLotto(String InputValue) {
        InputValue = InputValue.replaceAll(" ", "");
        String pattern = "(.+,+).+";
        if (!InputValue.matches(pattern)) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.getText());
        }
        List<String> numbers = List.of(InputValue.split(","));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LENGTH_ERROR.getText());
        }
        try {
            numbers.forEach((n) -> {
                Integer.parseInt(n);
            });
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NONDIGIT_ERROR.getText());
        }
    }

    public static void formatCheckBonus(String InputValue) {
        InputValue = InputValue.replaceAll(" ", "");
        String pattern = "\\d+";
        if (!InputValue.matches(pattern)) {
            throw new IllegalArgumentException(Error.NONDIGIT_ERROR.getText());
        }
        if (Integer.parseInt(InputValue) < 1 || Integer.parseInt(InputValue) < 1) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getText());
        }
    }
}
