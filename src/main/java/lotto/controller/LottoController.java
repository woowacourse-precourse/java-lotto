package lotto.controller;

import lotto.domain.lotto.Lotties;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.user.Purchase;
import lotto.domain.user.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
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
        String amount = inputView.inputLottoPurchaseAmount();
        purchase = Purchase.create(amount);
        lotties = createLottiesByPurchaseAmount(purchase.getLottoPublishCount());
        outputView.printLottoList(lotties.getLotties());
    }

    private Lotties createLottiesByPurchaseAmount(int issueCount) {
        List<Lotto> randomLottoNumbers = LottoGenerator.createRandomLottoNumberList(issueCount);
        return new Lotties(randomLottoNumbers);
    }

    protected int calculateWin() {
        userLotto = inputWinAndBonusNumber();
        Map<LottoRank, Long> lottoRankMap =
                lotties.generateLottoRankMap(userLotto.getLotto(), userLotto.getBonusNumber());
        return findWinAmount(lottoRankMap);
    }

    private UserLotto inputWinAndBonusNumber() {
        List<Integer> winNumber = inputView.inputUserWinNumber();
        int bonusNumber = inputView.inputUserBonusNumber();
        return new UserLotto(winNumber, bonusNumber);
    }

    private int findWinAmount(Map<LottoRank, Long> lottoRankMap) {
        lottoRanks = new LottoRanks(lottoRankMap);
        return lottoRanks.findTotalWinAmount();
    }

    protected void printResult(int totalWinAmount) {
        double lottoYield = purchase.findLottoYield(totalWinAmount);
        printWinInfoAndYieldAmount(lottoYield);
    }

    private void printWinInfoAndYieldAmount(double yield) {
        outputView.printWinResult(lottoRanks.getWinLottoInfoMap());
        outputView.printYieldResult(yield);
    }
}
