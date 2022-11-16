package lotto.service;

import lotto.domain.*;
import lotto.utils.InputParser;
import lotto.view.consoleinput.ConsoleInput;
import lotto.view.consoleoutput.ConsoleOutput;

import java.util.List;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private Money money;
    private BunchOfLottos bunchOfLottos;
    private WinningLotto winningLotto;

    private LottoStatistic statistic;

    public void inputMoney() {
        consoleOutput.printDirectiveAboutInputMoney();
        money = Money.from(InputParser.parseToInteger(consoleInput.readInput()));
    }

    public void createBunchOfLottos() {
        bunchOfLottos = BunchOfLottos.from(
                LottoAutoGenerator.generateBunchOfLottos(money.getMoney())
        );
        consoleOutput.printInformationAboutAmountOfLotto(money.getMoney());
        consoleOutput.printAllNumbersInBunchOfLottos(bunchOfLottos);
    }

    public void createWinningLottoNumbers() {
        consoleOutput.printDirectiveAboutInputWinningNumbers();
        List<Integer> winningBalls =
                InputParser.parseAllElementToInteger(
                        InputParser.divideInputBySeparator(consoleInput.readInput()));

        consoleOutput.printDirectiveAboutInputBonusNumber();
        Integer bonusBall = InputParser.parseToInteger(consoleInput.readInput());
        winningLotto = WinningLottoGenerator.generateWinningLotto(winningBalls, bonusBall);
    }

    public void getStatisticOfLotto() {
        statistic = LottoStatistic.from(bunchOfLottos.countLottoAward(winningLotto));
        consoleOutput.printInformationAboutStatisticOfWinningLotto(statistic, money.getMoney());
    }
}
