package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ValidCheck {
    private static final String PATTERN_COMMA_CHECK = "(.+,+).+";
    private static final String PATTERN_DIGIT = "\\d+";
    private static final String PATTERN_THOUSAND_UNIT = "\\d+000";

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
        if (!InputValue.matches(PATTERN_COMMA_CHECK)) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.getText());
        }
        if (List.of(InputValue.split(",")).size() != 6) {
            throw new IllegalArgumentException(Error.LENGTH_ERROR.getText());
        }
        try {
            List.of(InputValue.split(",")).forEach((n) -> {
                Integer.parseInt(n);
            });
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NONDIGIT_ERROR.getText());
        }
    }

    public static void formatCheckBonus(String InputValue) {
        InputValue = InputValue.replaceAll(" ", "");
        if (!InputValue.matches(PATTERN_DIGIT)) {
            throw new IllegalArgumentException(Error.NONDIGIT_ERROR.getText());
        }
        if (Integer.parseInt(InputValue) < 1 || Integer.parseInt(InputValue) > 45) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getText());
        }
    }

    public static void formatCheckPrice(String InputValue) {
        InputValue = InputValue.replaceAll(" ", "");
        if (!InputValue.matches(PATTERN_THOUSAND_UNIT)) {
            throw new IllegalArgumentException(Error.PURCHASE_UNIT_ERROR.getText());
        }
    }
}
