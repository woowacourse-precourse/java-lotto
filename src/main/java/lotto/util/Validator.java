package lotto.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public void validateWinningNumber(String[] winningNumber) {
        if (Arrays.stream(winningNumber).distinct().count() != winningNumber.length) {
            throw new IllegalArgumentException("[error]");
        }
        if (winningNumber.length != COUNT) {
            throw new IllegalArgumentException("[error]");
        }
        for (String number : winningNumber) {
            number = number.trim();
            isNumber(number);
            if (!isRangeNumber(Integer.valueOf(number))) {
                throw new IllegalArgumentException("[error]");
            }
        }
    }

    public void isNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        if (!pattern.matcher(number).find()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRangeNumber(int number) {
        return number >= START && number <= END;
    }
}
