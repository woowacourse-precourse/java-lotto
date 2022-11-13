package lotto.util;

import java.util.List;

public class ValidationUtil {

    final static int MIN_UNIT_OF_AMOUNT = 1000;
    final static int LENGTH_OF_WINNING_NUM_LIST = 6;
    final static int START_NUM = 1;
    final static int END_NUM = 45;

    public static boolean validatePositiveNum(int purchaseAmountInput) {
        return purchaseAmountInput > 0;
    }

    public static boolean validateRemainder(int purchaseAmountInput) {
        return purchaseAmountInput % MIN_UNIT_OF_AMOUNT == 0;
    }

    public static boolean isDigitAndComma(String winningNumInput) {
        for (int i=0; i<winningNumInput.length(); i++) {
            char winningNum = winningNumInput.charAt(i);
            if (!Character.isDigit(winningNum) && winningNum!=',') {
                return false;
            }
        }
        return true;
    }

    public static boolean isLength(List<Integer> winningNumInputList) {
        return winningNumInputList.size() == LENGTH_OF_WINNING_NUM_LIST;
    }
    public static boolean isInRange(Integer winningNum) {
        return winningNum >= START_NUM && winningNum <= END_NUM;
    }

    public static boolean isDuplicate(List<Integer> winningNumList, Integer winningNum) {
        return winningNumList.contains(winningNum);
    }

}
