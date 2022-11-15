package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Ticket;

public class PurchaseUI {
    private static final String MESSAGE = "구입금액을 입력해 주세요.";
    public Ticket purchase() {
        System.out.println(MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        return new Ticket(userInput);
    }
}
