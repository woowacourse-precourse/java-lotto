package lotto;

import java.util.Collections;
import java.util.List;

public class ValidCheck {
    public static void validateLotto(List<Integer> numbers) {
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getText());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LENGTH_ERROR.getText());
        }
    }

    public static void validateBounus(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getText());
        }
    }
}
