package lotto.service;

import lotto.domain.money.Money;
import lotto.lotto.LottoAutoGenerator;
import lotto.lotto.LottoCollection;
import lotto.lotto.WinningLotto;
import lotto.lotto.WinningLottoGenerator;
import lotto.utils.InputParser;
import lotto.view.consoleinput.ConsoleInput;
import lotto.view.consoleoutput.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();

    private Money money;
    private LottoCollection lottoCollection;
    private  WinningLotto winningLotto;

    public void inputMoney() {
        consoleOutput.printDirectiveAboutInputMoney();
        money = Money.of(InputParser.parseToInteger(consoleInput.readInput()));
    }

    public void createLottos() {
        lottoCollection = LottoCollection.of(
                LottoAutoGenerator.generateLottoCollection(money.getMoney())
        );
        consoleOutput.printAmountOfLottos(money.getMoney());
        consoleOutput.printAllNumberOfLottoCollection(lottoCollection);
    }

    public void createWinningLottoNumbers() {
        consoleOutput.printDirectiveAboutInputWinningNumber();
        List<Integer> winningBalls =
                InputParser.parseAllElementToInteger(
                        InputParser.divideInputBySeparator(consoleInput.readInput()));

        consoleOutput.printDirectiveAboutInputBonusNumber();
        Integer bounsBall = InputParser.parseToInteger(consoleInput.readInput());
        winningLotto = WinningLottoGenerator.generateWinningLotto(winningBalls, bounsBall);
    }
}
