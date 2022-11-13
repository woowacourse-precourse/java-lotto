package lotto.view;

import java.util.List;
import lotto.view.lottostats.LottoRanksResult;
import lotto.view.lottostats.LottoYieldResult;

public class OutputView {
    public static void showResult(List<Integer> lottoRanks, int lottoPrice) {
        showFrontMessage();
        LottoRanksResult.showRanksStats(lottoRanks);
        LottoYieldResult.showYield(lottoRanks, lottoPrice);
    }

    private static void showFrontMessage() {
        System.out.println(GameMessage.WINNING_STATS);
        System.out.println(GameMessage.THREE_HYPHEN);
    }
}
