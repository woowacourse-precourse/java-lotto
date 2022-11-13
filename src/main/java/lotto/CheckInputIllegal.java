package lotto;


import java.util.List;
import java.util.regex.Pattern;

public class CheckInputIllegal {
    ExceptionMessage exceptionMessage;
    Lotto lotto;
    private static String patternForNums = "/^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$/g";
    private static String patternForBonus = "/^\\d{1,2}$/g";

    public void checkUserPayIllegal(int userPayment) {
        if (userPayment <= 0 || userPayment % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(exceptionMessage.WRONG_PAYMENT));
        }
    }

    public void checkUserInputIllegal(String userInput) {
        if (!Pattern.matches(patternForNums, userInput)) {
            throw new IllegalArgumentException(String.valueOf(exceptionMessage.WRONG_NUM));
        }
    }

    public void checkUserBonusIllegal(String userBonus) {
        if (!Pattern.matches(patternForBonus, userBonus)) {
            throw new IllegalArgumentException(String.valueOf(exceptionMessage.WRONG_BONUS));
        }
    }

    public void checkUserNumListIllegal(List<Integer> userNumList) {
        lotto.validate(userNumList);
        for (int num : userNumList) {
            if (num < 1 || num > 45 ) {
                throw new IllegalArgumentException(String.valueOf(exceptionMessage.WRONG_NUM));
            }
        }

    }
}
