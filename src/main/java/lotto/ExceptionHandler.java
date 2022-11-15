package lotto;

import java.util.List;


/**
 * Handles possible exceptions from user input.
 *
 * @author Davin An
 * @version 1.0
 */
public class ExceptionHandler {
    public final String error01 = "[ERROR] 01 사용자가 아무것도 입력하지 않았습니다.";
    public final String error02 = "[ERROR] 02 사용자가 숫자 이외의 문자를 입력하였습니다.";
    public final String error03 = "[ERROR] 03 구입 금액이 1000원으로 나누어지지 않습니다.";
    public final String error04 = "[ERROR] 04 숫자의 갯수가 올바르지 않습니다.";
    public final String error05 = "[ERROR] 05 숫자가 범위가 올바르지 않습니다.";
    public final String error06 = "[ERROR] 06 당첨 번호의 형식이 올바르지 않습니다.";
    public final String error07 = "[ERROR] 07 중복되는 숫자가 입력되었습니다.";


    /**
     * Confirms the user's purchase amount is appropriate.
     *
     * @param input Purchase amount in string format
     */
    public void purchaseAmountException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(error01);
        } else if (isInteger(input)) {
            throw new IllegalArgumentException(error02);
        } else if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(error03);
        }
    }

    /**
     * Confirms the user's winning lotto numbers are appropriate.
     *
     * @param stringList Winning lotto numbers in List format
     */
    public void winningNumbersException(List<String> stringList) {
        if (stringList.size() != 6) {
            throw new IllegalArgumentException(error04);
        }
        for (int i = 0; i < stringList.size(); i++) {
            if (isInteger(stringList.get(i))) {
                throw new IllegalArgumentException(error06);
            } else if ((Integer.parseInt(stringList.get(i)) < 1) || (Integer.parseInt(stringList.get(i)) > 45)) {
                throw new IllegalArgumentException(error05);
            } else if (stringList.subList(i + 1, stringList.size()).contains(stringList.get(i))) {
                throw new IllegalArgumentException(error07);
            }
        }
    }


    /**
     * Confirms the user's bonus number is appropriate
     *
     * @param winningNum Current winning lotto numbers
     * @param bonusNum   Bonus lotto number
     */
    public void bonusNumberException(List<Integer> winningNum, String bonusNum) {
        if (bonusNum.isEmpty()) {
            throw new IllegalArgumentException(error01);
        } else if (isInteger(bonusNum)) {
            throw new IllegalArgumentException(error02);
        }
        int num = Integer.parseInt(bonusNum);
        if ((num < 1) || (num > 45)) {
            throw new IllegalArgumentException(error05);
        } else if (winningNum.contains(num)) {
            throw new IllegalArgumentException(error07);
        }
    }


    /**
     * Helper method to catch a NumberFormatException and change it into a IllegalArgumentException
     *
     * @param str String to confirm if integer or not
     * @return false if String is an integer, true otherwise
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
