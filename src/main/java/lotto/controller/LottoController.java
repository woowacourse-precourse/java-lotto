package lotto.controller;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {

    private final Statistics statistics;

    private Lotties lotties;

    private UserLotto userLotto;

    public LottoController(Statistics statistics) {
        this.statistics = statistics;
    }

    public void run() {
        try {
            int purchase = InputView.inputLottoPurchaseAmount();
            lotties = createLottiesByPurchaseAmount(purchase);

            userLotto = inputWinAndBonusNumber();
            findMatchAndBonusCount();

            statistics.findTotalWinAmount();
            printResults(purchase);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Lotties createLottiesByPurchaseAmount(int purchase) {
        Lotties lotties = Lotties.create(purchase);
        OutputView.printLottoList(lotties.getLotties());
        return lotties;
    }

    public UserLotto inputWinAndBonusNumber() {
        List<Integer> winNumber = InputView.inputUserWinNumber();
        int bonusNumber = InputView.inputUserBonusNumber();
        return new UserLotto(winNumber, bonusNumber);
    }

    public void findMatchAndBonusCount() {
        for (Lotto lotto : lotties.getLotties()) {
            int matchCount = lotto.findLottoWinCount(userLotto.getLotto());
            int bonusCount = userLotto.findBonusNumberWinCount(lotto.getNumbers());
            statistics.setLottoWinResultToMap(matchCount, bonusCount);
        }
    }

    public void printResults(int purchaseAmount) {
        OutputView.printWinResult(statistics.getWinLottoInfoMap());
        OutputView.printYieldResult(statistics.findLottoYield(purchaseAmount));
    }
}
