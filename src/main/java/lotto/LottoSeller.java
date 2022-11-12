package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.*;

public class LottoSeller {
    int payAmount;
    int numberOfTickets;

    public void getPayAmount() {
        System.out.println(MESSAGE_INPUT_PAY_AMOUNT);
        this.payAmount = Integer.parseInt(Console.readLine());
    }

    public int countTicket() {
        if (payAmount % 1000 == 0) {
            this.numberOfTickets = payAmount / 1000;
            System.out.print(this.numberOfTickets + MESSAGE_NUMBER_OF_TICKET_IS);
        }
        if (payAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
        return this.numberOfTickets;
    }

}