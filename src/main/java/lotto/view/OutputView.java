package lotto.view;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.text.DecimalFormat;

public class OutputView {
    private static final String STATISTIC_START = "당첨 통계";
    private static final String LINE_DIVIDER = "---";
    private static final String STATISTIC_INFORMATION = "%d개 일치 (%s원) - %d개\n";
    private static final String STATISTIC_INFORMATION_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String LOTTO_YIELD = "총 수익률은 %s%%입니다.";
    private static final int CHECK_BONUS_NUMBER = 5;
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printResult(LottoResult lottoResult, LottoPurchaseAmount lottoPurchaseAmount) {
        System.out.println(STATISTIC_START);
        System.out.println(LINE_DIVIDER);
        for (Rank rank: Rank.getSortedRank()) {
           printLottoResult(rank, lottoResult.getLottoResult().get(rank));
        }
        System.out.printf(LOTTO_YIELD, lottoResult.getLottoYield(lottoPurchaseAmount));
    }

    private void printLottoResult(Rank rank, int winningCount) {
        if (rank.getMatchCount() == CHECK_BONUS_NUMBER && rank.isHitBonusNumber()){
            System.out.printf(STATISTIC_INFORMATION_WITH_BONUS, rank.getMatchCount(),
                    decimalFormat.format(rank.getReward()), winningCount);
        }
        if (!rank.isHitBonusNumber()){
            System.out.printf(STATISTIC_INFORMATION, rank.getMatchCount(), decimalFormat.format(rank.getReward()),
                    winningCount);
        }
    }
}
