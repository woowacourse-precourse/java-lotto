package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.*;

public class LottoPurchase {
    int payAmount;
    int numberOfTicket;

    public void getPayAmount() {
        System.out.println(MESSAGE_INPUT_PAY_AMOUNT);
        this.payAmount = Integer.parseInt(Console.readLine());
    }

    public void countTicket(int payAmount) {
        if (payAmount % 1000 == 0) {
            this.numberOfTicket = payAmount / 1000;
        }
        if (payAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
    }
}
