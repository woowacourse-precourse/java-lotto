package lotto.util;

import java.util.List;

public class Validator {
    private final String INVALID_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private final String INVALID_MONEY = "[ERROR] 1000원 단위로 입력이 가능합니다.";
    private final int MONEY_UNIT = 1000;
    private final int NOTHING_CHANGES = 0;

    public int moneyInputValidator(String money) {
        int moneyNumber = changeNumber(money);
        checkChanges(moneyNumber);
        return moneyNumber;
    }

    public int changeNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    public void checkChanges(int money) {
        if (money % MONEY_UNIT == NOTHING_CHANGES) {
            return;
        }
        throw new IllegalArgumentException(INVALID_MONEY);
    }

    public static void winningNumberInputValidator(String money) {

    }

    public static void checkValidNumber(int number) {

    }

    public static void checkDuplication(List<Integer> numbers, int number) {

    }

}
