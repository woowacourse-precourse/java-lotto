package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.MESSAGE_INPUT_PAY_AMOUNT;

public class LottoPurchase {
    int payAmount;
    int numberOfTicket;

    public void getPayAmount() {
        this.payAmount = Integer.parseInt(Console.readLine());
    }

    public void countTicket(int payAmount) {
        if (payAmount % 1000 == 0) {
            this.numberOfTicket = payAmount / 1000;
        }
        if (payAmount % 1000 != 0) {
            throw new IllegalArgumentException(MESSAGE_INPUT_PAY_AMOUNT);
        }
    }
}
