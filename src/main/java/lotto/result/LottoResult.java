package lotto.result;

import java.util.List;
import lotto.GameMessage;
import lotto.domain.Rank;

public class LottoResult {
    private static final String YIELD_FORMAT = "%.1f";
    private static final int PERCENTAGE = 100;

    public static void showResult(List<Integer> lottoRanks, int lottoPrice) {
        System.out.println(GameMessage.WINNING_STATS);
        System.out.println(GameMessage.THREE_HYPHEN);
        for (Rank rank : Rank.values()) {
            showRank(lottoRanks, rank);
        }
        showYield(lottoRanks, lottoPrice);
    }

    private static void showRank(List<Integer> lottoRanks, Rank rank) {
        if (rank != Rank.ZERO) {
            System.out.println(rank.toString() + lottoRanks.get(rank.getRank()) + GameMessage.RESULT_RANK_UNITS);
        }
    }

    private static String calculateYield(List<Integer> lottoRanks, int lottoPrice) {
        float prizeAmount = 0;
        String resultYield;
        for (Rank rank : Rank.values()) {
            prizeAmount += lottoRanks.get(rank.getRank()) * rank.getMoney();
        }
        resultYield = String.format(YIELD_FORMAT, (prizeAmount / lottoPrice) * PERCENTAGE);
        return resultYield;
    }

    private static void showYield(List<Integer> lottoRanks, int lottoPrice) {
        System.out.print(GameMessage.FRONT_YIELD_MESSAGE);
        System.out.print(calculateYield(lottoRanks, lottoPrice));
        System.out.println(GameMessage.BACK_YIELD_MESSAGE);
    }
}
