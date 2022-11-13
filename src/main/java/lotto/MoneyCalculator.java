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


}
