package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.UI.ConsoleView;
import lotto.UI.InputMoney;
import lotto.UI.InputWinningAndBonusNumbers;

public class LottoGame {
    private List<Lotto> lottos;
    private int money;
    private Lotto winningNumbers;
    private Integer bonusNumber;
    private double profitRate;

    public LottoGame() {
    }

    public void start() {
        InputMoney inputMoney = new InputMoney();
        InputWinningAndBonusNumbers inputAnswers = new InputWinningAndBonusNumbers();
        ConsoleView view = new ConsoleView();

        buyLotto(inputMoney, view);
        drawLotto(inputAnswers, view);
        checkResult(view);
    }

    private void buyLotto(InputMoney inputMoney, ConsoleView view) {
        view.printRequestMoney();
        money = inputMoney.input();

        view.printNumberOfLotto(money);
        LottoGenerator generator = new LottoGenerator(money);
        lottos = generator.generateLottos();
        view.printLottos(lottos);
    }

    private void drawLotto(InputWinningAndBonusNumbers inputAnswers, ConsoleView view) {
        view.printRequestWinningNumbers();
        winningNumbers = inputAnswers.inputWinningNumbers();

        view.printRequestBonusNumber();
        bonusNumber = inputAnswers.inputBonusNumber();
    }

    private void checkResult(ConsoleView view) {
        CheckLottosPrize checkPrize = new CheckLottosPrize(lottos, winningNumbers, bonusNumber);

        Map<String, Integer> totalPrize = checkPrize.getTotalPrize();
        view.printTotalPrize(totalPrize);
        CalculateProfitRate calculateProfitRate = new CalculateProfitRate(money, totalPrize);
        profitRate = calculateProfitRate.getProfitRate();
        view.printProfitRate(profitRate);
    }
}
