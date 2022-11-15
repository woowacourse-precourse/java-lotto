package lotto.controller;

import lotto.domain.lotto.Lotties;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.rank.Statistics;
import lotto.domain.user.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    private final Statistics statistics;

    private Lotties lotties;

    private UserLotto userLotto;

    private LottoRanks lottoRanks;

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

            int totalWinAmount = findWinAmount(lottoRankMap);

            printResults(totalWinAmount);
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

    public int findWinAmount(Map<LottoRank, Long> lottoRankMap) {
        lottoRanks = new LottoRanks(lottoRankMap);
        return lottoRanks.findTotalWinAmount();
    }

    public void printResults(int purchaseAmount) {
        OutputView.printWinResult(lottoRanks.getWinLottoInfoMap());
        OutputView.printYieldResult(statistics.findLottoYield(purchaseAmount));
    }
}
