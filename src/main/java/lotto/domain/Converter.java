package lotto.domain;

import static lotto.domain.ErrorMessages.MONEY_NUMBER_ERROR;

public class Converter {
    public static int changeToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR.toString());
        }
    }
}
