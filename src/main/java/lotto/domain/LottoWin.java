package lotto.domain;

import java.util.Arrays;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;

public class LottoWin {
    private static final String SEPARATOR = ",";
    private final Lotto winningNumbers;

    public LottoWin(String numbers) {
        validateSeparator(numbers);
    }

    private void validateSeparator(String numbers) {
        if(!numbers.contains(SEPARATOR)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SEPARATOR);
        }
    }
}
