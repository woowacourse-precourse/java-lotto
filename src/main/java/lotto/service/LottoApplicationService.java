package lotto.service;

import lotto.constant.Information;
import lotto.domain.money.Money;
import lotto.view.consoleinput.ConsoleInput;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();

    private Money buyer;

    public void inputMoney() {
        System.out.println(Information.INPUT_MONEY.getMessage());
        buyer = Money.of(consoleInput.readNumber());
    }
}
