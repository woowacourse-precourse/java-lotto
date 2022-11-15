package lotto.view;

import static lotto.domain.LottoInfo.BLANK;
import static lotto.domain.LottoInfo.price;
import static lotto.utils.Constant.PROFIT_RATE_MESSAGE;
import static lotto.utils.Constant.PURCHASE_MESSAGE;
import static lotto.utils.Constant.STATISTICS_LINE;
import static lotto.utils.Constant.STATISTICS_MESSAGE;
import static lotto.utils.Constant.WINNING_BONUS_STATUS_MESSAGE;
import static lotto.utils.Constant.WINNING_STATUS_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottoPurchaseNumber(int purchaseNumbers) {
        System.out.println(purchaseNumbers + PURCHASE_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinnerStatistics(Map<Integer, Integer> winnerStatistics) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_LINE);

        for (int winning = 5; winning > 0; winning--) {
            printStatistics(winnerStatistics, winning);
        }
    }

    private static void printStatistics(Map<Integer, Integer> winnerStatistics, int winning) {
        if (price.get(winning).isCorrectBonus()) {
            System.out.printf(WINNING_BONUS_STATUS_MESSAGE,
                    price.get(winning).getMatchCount(),
                    price.get(winning).getWinningPrize(),
                    winnerStatistics.getOrDefault(price.get(winning).getWinning(), BLANK.getWinning()));
            return;
        }
        System.out.printf(WINNING_STATUS_MESSAGE,
                price.get(winning).getMatchCount(),
                price.get(winning).getWinningPrize(),
                winnerStatistics.getOrDefault(price.get(winning).getWinning(), BLANK.getWinning()));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
