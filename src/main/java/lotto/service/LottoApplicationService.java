package lotto.service;

import lotto.constant.Information;
import lotto.utils.InputParser;
import lotto.domain.money.Money;
import lotto.view.consoleinput.ConsoleInput;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();

    private Money money;

    public void inputMoney() {
        System.out.println(Information.INPUT_MONEY.getMessage());
        money = Money.of(InputParser.parseToInteger(consoleInput.readInput()));
    }
}
