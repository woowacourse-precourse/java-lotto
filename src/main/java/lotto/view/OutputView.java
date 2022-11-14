package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.MatchingType;
import lotto.PrizeType;
import lotto.Profit;
import lotto.Quantity;
import lotto.WinningStat;

public class OutputView {

    private static final String LOTTO_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String LOTTO_STAT_INTRO_MESSAGE = "\n당첨 통계";
    private static final String DIVIDING_LINE_MESSAGE = "---";
    private static final String MATCH_MESSAGE = "%d개 일치";
    private static final String PRIZE_MESSAGE = " (%s원)";
    private static final String BONUS_PRIZE_MESSAGE = ", 보너스 볼 일치";
    private static final String COUNT_MESSAGE = " - %d개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoQuantity(Quantity quantity) {
        String result = String.format(LOTTO_QUANTITY_MESSAGE, quantity.getNumber());

        System.out.println(result);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printStatistics(List<WinningStat> winningStats) {
        System.out.println(LOTTO_STAT_INTRO_MESSAGE);
        System.out.println(DIVIDING_LINE_MESSAGE);

        for (WinningStat winningStat : winningStats) {
            MatchingType matchingType = winningStat.getMatchingType();
            PrizeType prizeType = matchingType.getPrizeType();
            int count = winningStat.getCount();
            String result = makeStatSentence(matchingType, prizeType, count);

            System.out.println(result);
        }
    }

    private static String makeStatSentence(MatchingType matchingType, PrizeType prizeType, int count) {
        String matchMessage = String.format(MATCH_MESSAGE, matchingType.getMatchCount());

        String prizeMessage = String.format(PRIZE_MESSAGE, prizeType.getMoney());
        if (matchingType == MatchingType.FIVE_WITH_BONUS_MATCH) {
            prizeMessage = BONUS_PRIZE_MESSAGE.concat(prizeMessage);
        }

        String countMessage = String.format(COUNT_MESSAGE, count);


        return matchMessage + prizeMessage + countMessage;
    }

    public static void printProfit(Profit profit, Quantity quantity) {
        double profitPercent = profit.calculate(quantity);
        String result = String.format(PROFIT_MESSAGE, profitPercent);
        System.out.println(result);
    }
}
