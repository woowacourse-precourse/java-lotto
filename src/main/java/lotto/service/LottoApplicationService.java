package lotto.service;

import lotto.constant.Information;
import lotto.domain.buyer.Buyer;
import lotto.view.consoleinput.ConsoleInput;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();

    private Buyer buyer;

    public void inputMoney() {
        System.out.println(Information.INPUT_MONEY.getMessage());
        buyer = Buyer.of(consoleInput.readNumber());
    }
}
