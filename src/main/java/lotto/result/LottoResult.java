package lotto.result;

import java.util.List;
import lotto.GameMessage;
import lotto.domain.Rank;

public class LottoResult {
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
