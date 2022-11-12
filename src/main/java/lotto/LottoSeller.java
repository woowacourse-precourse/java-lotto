package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.ERROR_INPUT_PAY_AMOUNT;
import static lotto.Constant.MESSAGE_INPUT_PAY_AMOUNT;

public class LottoSeller {
    int payAmount;
    int numberOfTickets;

    public void getPayAmount() {
        System.out.println(MESSAGE_INPUT_PAY_AMOUNT);
        this.payAmount = Integer.parseInt(Console.readLine());
    }

    public void countTicket(int payAmount) {
        if (payAmount % 1000 == 0) {
            this.numberOfTickets = payAmount / 1000;
            System.out.println(this.numberOfTickets + "개를 구매했습니다.");
        }
        if (payAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
    }

}