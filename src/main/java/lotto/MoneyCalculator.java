package lotto;

import java.util.Scanner;

public class MoneyCalculator {
    public int receivedMoney = 0;

    public MoneyCalculator() {
    }
    public int inputMoney(int Money) {
        receivedMoney = Money;
        validateInputMoney(receivedMoney);

        return receivedMoney;
    }
    private void validateInputMoney(int receivedMoney) {
        if (receivedMoney % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessages.INPUT_MONEY_IS_NOT_THOUSAND_UNITS.getMessage());
        if (receivedMoney < 0)
            throw new IllegalArgumentException(ErrorMessages.INPUT_MONEY_IS_NOT_UP_ZERO.getMessage());
    }

}
