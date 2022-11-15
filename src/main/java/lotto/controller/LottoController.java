package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


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
            Map<LottoRank, Long> lottoRankMap =
                    lotties.generateLottoRankMap(userLotto.getLotto(), userLotto.getBonusNumber());

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

    public void printResults(int purchaseAmount) {
        OutputView.printWinResult(statistics.getWinLottoInfoMap());
        OutputView.printYieldResult(statistics.findLottoYield(purchaseAmount));
    }
}
