package lotto.exception;

import java.util.regex.Pattern;

public class BonusNumberException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[1-9]*?");

    public void maxAndMinNumber(int bonusNumber) {
        try {
            if (bonusNumber > 45 || bonusNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 1~45의 값이 아닙니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void notNumber(String bonusNumber) {
        try {
            if (bonusNumber.isEmpty() ||
                    !IsOnlyNumber.matcher(bonusNumber).matches()) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 들어왔습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void fullException(String bonusNumber) {
        notNumber(bonusNumber);
        maxAndMinNumber(Integer.parseInt(bonusNumber));
    }
}
