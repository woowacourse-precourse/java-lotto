package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.MatchingType;
import lotto.PrizeType;
import lotto.Profit;
import lotto.Quantity;
import lotto.WinningStat;

public class OutputView {

    private static final String LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_STAT_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE_MESSAGE = "---";

    public static void printLottoQuantity(Quantity quantity) {
        String result = quantity.getNumber()
                + " "
                + LOTTO_QUANTITY_MESSAGE;

        System.out.println(result);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printStatistics(List<WinningStat> winningStats) {
        System.out.println(LOTTO_STAT_MESSAGE);
        System.out.println(DIVIDING_LINE_MESSAGE);

        for (WinningStat winningStat : winningStats) {
            MatchingType matchingType = winningStat.getMatchingType();
            int count = winningStat.getCount();
            PrizeType prizeType = matchingType.getPrizeType();

            String result = matchingType.getMatchCount() + "개 일치 (" + prizeType.getMoney() + ")원 - " + count + "개";
            System.out.println(result);
        }
    }

    public static void printProfit(Profit profit, Quantity quantity) {
        double profitPercent = profit.calculate(quantity);
        System.out.println("총 수익률은 " + profitPercent + "%입니다.");
    }
}
