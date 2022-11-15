package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Ticket;

public class PurchaseUI {
    private String message = "구입금액을 입력해 주세요.";
    public Ticket purchase() {
        System.out.println(message);
        String userInput = Console.readLine();
        System.out.println();
        return new Ticket(userInput);
    }
}
