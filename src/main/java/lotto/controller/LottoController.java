package lotto.controller;

import static lotto.money.Earning.getEarning;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinningNumber;
import static lotto.view.OutputView.printBlank;
import static lotto.view.OutputView.printGeneratedLotto;
import static lotto.view.OutputView.printInputBonusNumber;
import static lotto.view.OutputView.printInputPurchaseMoney;
import static lotto.view.OutputView.printInputWinningNumber;
import static lotto.view.OutputView.printResult;

import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;
import lotto.money.Money;
import lotto.money.Yield;
import lotto.rank.Rank;
import lotto.rank.RankChecker;

public class LottoController {

    public void playLottoGame() {
        Money purchaseMoney = getPurchaseMoney();
        printBlank();
        List<Lotto> lottos = getGeneratedLotto(purchaseMoney);
        printBlank();
        WinningLotto winningLotto = getWinningLotto();
        printBlank();
        getResult(lottos, winningLotto, purchaseMoney);
    }

    private Money getPurchaseMoney() {
        printInputPurchaseMoney();
        return inputPurchaseMoney();
    }

    private List<Lotto> getGeneratedLotto(Money purchaseMoney) {
        int lottoCount = purchaseMoney.calculateLottoCount();
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        printGeneratedLotto(lottos);
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        printInputWinningNumber();
        List<LottoNumber> winningNumber = inputWinningNumber();
        printBlank();
        printInputBonusNumber();
        LottoNumber bonusNumber = inputBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private void getResult(List<Lotto> lottos, WinningLotto winningLotto, Money purchaseMoney) {
        Map<Rank, Integer> rankMap = RankChecker.checkRank(lottos, winningLotto);
        Money earning = getEarning(rankMap);
        printResult(rankMap, new Yield(purchaseMoney, earning));
    }
}
