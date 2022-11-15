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

    public static void showGeneratedLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void showLottoCount(int lottoCount) {
        System.out.println(String.valueOf(lottoCount) + GameMessage.RESULT_RANK_UNITS + GameMessage.BUY_RESULT);
    }

    private static void showFrontMessage() {
        System.out.println(GameMessage.WINNING_STATS);
        System.out.println(GameMessage.THREE_HYPHEN);
    }
}
