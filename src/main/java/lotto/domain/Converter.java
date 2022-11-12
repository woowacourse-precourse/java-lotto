package lotto.domain;

import static lotto.domain.Error.NOT_NUMBER_ERROR;

public class Converter {
    public static int changeToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.toString());
        }
    }
}
