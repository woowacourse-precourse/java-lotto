package lotto.util;

import java.util.List;

public class ValidationUtil {

    final static int MIN_UNIT_OF_AMOUNT = 1000;
    final static int LENGTH_OF_STRING_WINNING_NUM = 11;
    final static int START_NUM = 1;
    final static int END_NUM = 45;

    public static boolean validatePositiveNum(int purchaseAmountInput) {
        return purchaseAmountInput > 0;
    }

    public static boolean validateRemainder(int purchaseAmountInput) {
        return purchaseAmountInput % MIN_UNIT_OF_AMOUNT == 0;
    }

    public static boolean isLengthIncludingComma(String winningNumInput) {
        return winningNumInput.length() == LENGTH_OF_STRING_WINNING_NUM;
    }

    public static boolean isComma(String winningNumInput) {
        for (int i=0; i<LENGTH_OF_STRING_WINNING_NUM; i++) {
            if (i%2==1 && winningNumInput.charAt(i)!=',') {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigit(String winningNumInput) {
        char[] winningNumberArray = winningNumInput.toCharArray();
        for (char winningNumberChar : winningNumberArray) {
            if (!Character.isDigit(winningNumberChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInRange(Integer winningNum) {
        return winningNum >= START_NUM && winningNum <= END_NUM;
    }

    public static boolean isDuplicate(List<Integer> winningNumList, Integer winningNum) {
        return winningNumList.contains(winningNum);
    }

}
