package lotto.result;

import java.util.List;
import lotto.GameMessage;
import lotto.domain.Rank;

public class LottoResult {

    public static void showResult(List<Integer> lottoRanks) {
        for (Rank rank : Rank.values()) {
            showRank(lottoRanks, rank);
        }
    }

    private static void showRank(List<Integer> lottoRanks, Rank rank) {
        if (rank != Rank.ZERO) {
            System.out.println(rank.toString() + lottoRanks.get(rank.getRank()) + GameMessage.RESULT_RANK_UNITS);
        }
    }
}
