package lotto.ExceptionChecker;

import java.util.NoSuchElementException;

public class IntegerChecker {
    private final int money;

    public IntegerChecker(String userInputMoney) {
        validateInteger(userInputMoney);
        this.money = Integer.parseInt(userInputMoney);
    }

    public int getMoney() {
        return money;
    }

    private void validateInteger(String userInputMoney) {
        try {
            if (!integerTrue(userInputMoney)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");
            IllegalArgumentException.printStackTrace();

            throw new NoSuchElementException();
        }

    }

    private boolean integerTrue(String userInputMoney) {
        try {
            Integer.parseInt(userInputMoney);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
