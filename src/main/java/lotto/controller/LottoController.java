package lotto.controller;

import static lotto.domain.result.Statistics.makeStatistics;
import static lotto.view.OutputView.printLottoPurchaseCount;
import static lotto.view.OutputView.printTotalLottos;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.TotalLottos;
import lotto.domain.purchaseAmount.PurchaseAmount;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningResult;
import lotto.domain.winningElements.WinningElements;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
        long lottoPurchaseCount = takeLottoPurchaseCount(purchaseAmount);
        TotalLottos totalLottos = takeTotalLottos(lottoPurchaseCount);

        List<Integer> winningNumbers = WinningElements.getWinningNumbers();
        int bonusNumber = WinningElements.getBonusNumber();
        Map<LottoRank, Integer> lottoResult = takeWinningResult(totalLottos, winningNumbers, bonusNumber);
    }

    public static long takeLottoPurchaseCount(long purchaseAmount) {
        long lottoPurchaseCount = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);
        printLottoPurchaseCount(lottoPurchaseCount);

        return lottoPurchaseCount;
    }

    public static TotalLottos takeTotalLottos(long lottoPurchaseCount) {
        TotalLottos totalLottos = new TotalLottos(lottoPurchaseCount);
        printTotalLottos(totalLottos);

        return totalLottos;
    }

    public static Map<LottoRank, Integer> takeWinningResult(TotalLottos totalLottos, List<Integer> winningNumbers, int bonusNumber) {
        List<Lotto> lottos = totalLottos.getTotalLottos();

        List<Integer> matchingCountOfAllLottos = WinningResult.getMatchingCountOfAllLottos(lottos, winningNumbers);
        List<Boolean> bonusNumberMatchingOfAllLottos = WinningResult.getBonusNumberMatchingOfAllLottos(lottos, bonusNumber);

        Map<LottoRank, Integer> lottoResult = makeStatistics(matchingCountOfAllLottos, bonusNumberMatchingOfAllLottos);

        return lottoResult;
    }
}
