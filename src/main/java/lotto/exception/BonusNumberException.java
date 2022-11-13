package lotto.exception;

import java.util.regex.Pattern;

public class BonusNumberException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[0-9]*?");
    private static final String MAX_AND_MIN = "[ERROR] 1~45의 값이 아닙니다.";
    private static final String NOT_NUMBER = "[ERROR] 숫자가 아닌 값이 들어왔습니다.";

    public void maxAndMinNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(MAX_AND_MIN);
        }
    }

    public void notNumber(String bonusNumber) {
        if (bonusNumber.isEmpty() ||
                !IsOnlyNumber.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public void fullException(String bonusNumber) {
        notNumber(bonusNumber);
        maxAndMinNumber(Integer.parseInt(bonusNumber));
    }
}
