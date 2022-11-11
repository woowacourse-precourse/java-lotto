package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.PriceCalculator;
import lotto.domain.Rank;
import lotto.domain.WinChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private int purchaseMoney;
    private LottoGame lottoGame;
    private WinChecker winChecker;

    private void createLottoPurchase() {
        OutputView.printStartMesseage();
        purchaseMoney = InputView.getPurchase();
        lottoGame = new LottoGame(purchaseMoney);

        List<Lotto> lottos = lottoGame.getUserLottos();

        OutputView.printLottoNumber(purchaseMoney / 1000);
        OutputView.printLotto(lottos);
    }

    private void createWinChecker() {
        OutputView.printRequestWinningNumber();
        List<Integer> winningNumber = InputView.getWinningNumber();

        OutputView.printRequestBonusNumber();
        int bonusNumber = InputView.getBonusNumber();

        List<Lotto> lottos = lottoGame.getUserLottos();
        winChecker = new WinChecker(winningNumber, bonusNumber);
    }

    private Map<Rank, Integer> createResult() {
        List<Lotto> lottos = lottoGame.getUserLottos();

        return winChecker.checkLotto(lottos);
    }

    private void checkFifth(Map<Rank, Integer> result) {
        int count;

        count = result.getOrDefault(Rank.FIFTH, 0);
        OutputView.printFifth(count);
    }

    private void checkFourth(Map<Rank, Integer> result) {
        int count;

        count = result.getOrDefault(Rank.FOURTH, 0);
        OutputView.printFourth(count);
    }

    private void checkThird(Map<Rank, Integer> result) {
        int count;

        count = result.getOrDefault(Rank.THIRD, 0);
        OutputView.printThird(count);
    }

    private void checkSecond(Map<Rank, Integer> result) {
        int count;

        count = result.getOrDefault(Rank.SECOND, 0);
        OutputView.printSecond(count);
    }

    private void checkFirst(Map<Rank, Integer> result) {
        int count;

        count = result.getOrDefault(Rank.FIRST, 0);
        OutputView.printFirst(count);
    }

    private void checkWin(Map<Rank, Integer> result) {
        checkFifth(result);
        checkFourth(result);
        checkThird(result);
        checkSecond(result);
        checkFirst(result);
    }

    private void checkYield(Map<Rank, Integer> result) {
        float yield = PriceCalculator.getyield(result, purchaseMoney);
        OutputView.printYield(yield);
    }

    public void run() {
        createLottoPurchase();

        createWinChecker();

        Map<Rank, Integer> result = createResult();

        checkWin(result);
        checkYield(result);
    }
}
