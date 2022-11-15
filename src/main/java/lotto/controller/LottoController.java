package lotto.controller;

import lotto.domain.lotto.Lotties;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.user.Purchase;
import lotto.domain.user.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    private Lotties lotties;
    private UserLotto userLotto;
    private LottoRanks lottoRanks;
    private Purchase purchase;

    public void run() {
        try {
            issueLotto();
            int winAmount = calculateWin();
            printResult(winAmount);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void issueLotto() {
        String amount =  InputView.inputLottoPurchaseAmount();
        purchase = Purchase.create(amount);
        lotties = createLottiesByPurchaseAmount(purchase.getLottoPublishCount());
    }

    protected int calculateWin() {
        userLotto = inputWinAndBonusNumber();
        Map<LottoRank, Long> lottoRankMap =
                lotties.generateLottoRankMap(userLotto.getLotto(), userLotto.getBonusNumber());
        return findWinAmount(lottoRankMap);
    }

    protected void printResult(int totalWinAmount) {
        double lottoYield = purchase.findLottoYield(totalWinAmount);
        printWinInfoAndYieldAmount(lottoYield);
    }

    protected Lotties createLottiesByPurchaseAmount(int purchase) {
        Lotties lotties = Lotties.create(purchase);
        OutputView.printLottoList(lotties.getLotties());
        return lotties;
    }

    protected UserLotto inputWinAndBonusNumber() {
        List<Integer> winNumber = InputView.inputUserWinNumber();
        int bonusNumber = InputView.inputUserBonusNumber();
        return new UserLotto(winNumber, bonusNumber);
    }

    protected int findWinAmount(Map<LottoRank, Long> lottoRankMap) {
        lottoRanks = new LottoRanks(lottoRankMap);
        return lottoRanks.findTotalWinAmount();
    }

    protected void printWinInfoAndYieldAmount(double yield) {
        OutputView.printWinResult(lottoRanks.getWinLottoInfoMap());
        OutputView.printYieldResult(yield);
    }
}
