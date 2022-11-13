package lotto.view.lottostats;

import java.util.List;
import lotto.view.GameMessage;
import lotto.domain.Rank;

public class LottoYieldResult {
    private static final String YIELD_FORMAT = "%.1f";
    private static final int PERCENTAGE = 100;

    public static void showYield(List<Integer> lottoRanks, int lottoPrice) {
        System.out.print(GameMessage.FRONT_YIELD_MESSAGE);

        System.out.print(calculateYield(lottoRanks, lottoPrice));

        System.out.println(GameMessage.BACK_YIELD_MESSAGE);
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
}
