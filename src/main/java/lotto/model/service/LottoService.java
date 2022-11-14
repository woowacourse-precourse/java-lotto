package lotto.model.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningNumber;
import lotto.model.domain.WinningStatistics;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public Lottos createLottos() {
        String money = InputView.requestMoney();
        PayingMoney payingMoney = new PayingMoney(money);
        int numOfLottoBuying = payingMoney.countNumberOfLottoBuying();
        List<List<Integer>> randomNumbers = Utils.createRandomNumbers(NUM_MIN, NUM_MAX, LOTTO_SIZE, numOfLottoBuying);
        Lottos lottos = new Lottos(randomNumbers);

        OutputView.printLottos(numOfLottoBuying, lottos.toString());
        return lottos;
    }

    public WinningNumber createWinnerNumber() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return new WinningNumber(winningNumber, bonusNumber);
    }

    public void computeWinningStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningNumber);

        OutputView.printWinningStatistics(winningStatistics.get());
        OutputView.printTotalYield(winningStatistics.computeTotalYield());
    }
}
