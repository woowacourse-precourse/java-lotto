package lotto;

import java.util.List;

import static lotto.LottoErrorCheck.checkBonusNumberIncludedWinningNumber;
import static lotto.LottoInput.*;
import static lotto.LottoIssue.issueLotto;
import static lotto.LottoStatistics.*;

public class LottoRun {
    public static void runLottoApp() {
        try {
            int lottoCount = howMuchLottoBuyInput();
            List<Lotto> lotto = issueLotto(lottoCount);

            List<Integer> winningNumber = winningNumberInput();
            Integer bonusNumber = bonusNumberInput();
            checkBonusNumberIncludedWinningNumber(winningNumber, bonusNumber);

            List<Integer> lottoResult = resultWinningLottery(lotto, winningNumber, bonusNumber);
            double earningRate = calculateLottoEarningsRate(lottoResult, lottoCount);
            winningStatistics(lottoResult, earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
