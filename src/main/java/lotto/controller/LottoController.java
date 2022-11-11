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

    public void run(){
        OutputView.printStartMesseage();
        int purchaseMoney = InputView.getPurchase();
        LottoGame lottoGame = new LottoGame(purchaseMoney);
        List<Lotto> lottos = lottoGame.getUserLottos();
        OutputView.printLottoNumber(purchaseMoney / 1000);
        OutputView.printLotto(lottos);

        OutputView.printRequestWinningNumber();
        List<Integer> winningNumber = InputView.getWinningNumber();

        OutputView.printRequestBonusNumber();
        int bonusNumber = InputView.getBonusNumber();

        WinChecker winChecker = new WinChecker(winningNumber, bonusNumber);
        Map<Rank, Integer> result = winChecker.checkLotto(lottos);

        int count = result.getOrDefault(Rank.FIFTH, 0);
        OutputView.printFifth(count);

        count = result.getOrDefault(Rank.FOURTH, 0);
        OutputView.printFourth(count);

        count = result.getOrDefault(Rank.THIRD, 0);
        OutputView.printThird(count);

        count = result.getOrDefault(Rank.SECOND, 0);
        OutputView.printSecond(count);

        count = result.getOrDefault(Rank.FIRST, 0);
        OutputView.printFirst(count);

        float yield = PriceCalculator.getyield(result, purchaseMoney);
        OutputView.printYield(yield);
    }
}
