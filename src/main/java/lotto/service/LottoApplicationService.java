package lotto.service;

import lotto.constant.Information;
import lotto.lotto.LottoAutoGenerator;
import lotto.lotto.LottoCollection;
import lotto.utils.InputParser;
import lotto.domain.money.Money;
import lotto.view.consoleinput.ConsoleInput;
import lotto.view.consoleoutput.ConsoleOutput;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private Money money;
    private LottoCollection lottoCollection;

    public void inputMoney() {
        System.out.println(Information.INPUT_MONEY.getMessage());
        money = Money.of(InputParser.parseToInteger(consoleInput.readInput()));
    }

    public void createLottos() {
        lottoCollection = LottoCollection.of(
                LottoAutoGenerator.generateLottoCollection(money.getMoney())
        );
        consoleOutput.printAmountOfLottos(money.getMoney());
        consoleOutput.printAllNumberOfLottoCollection(lottoCollection);
    }
}
