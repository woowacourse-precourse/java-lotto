package lotto.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    public void validateWinningNumber(String[] winningNumber) {
        if (Arrays.stream(winningNumber).distinct().count() != winningNumber.length) {
            throw new IllegalArgumentException("[error]");
        }
        if (winningNumber.length != 6) {
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
        return number >= 1 && number <= 45;
    }
}
