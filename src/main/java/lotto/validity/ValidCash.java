package lotto.validity;

import lotto.constants.Constants;

public class ValidCash {
    public static final String ErrorMessage_NotThousand = "[ERROR] 1000원 단위로 입력해 주세요.";
    public static boolean validCash(int cash) {
        try {
            return cash% Constants.PRICE == 0;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage_NotThousand);
        }
    }
}
