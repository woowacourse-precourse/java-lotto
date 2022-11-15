package lotto.view;

import static lotto.constant.OutputConstant.BONUS_PRIZE_MESSAGE;
import static lotto.constant.OutputConstant.COUNT_MESSAGE;
import static lotto.constant.OutputConstant.DIVIDING_LINE_MESSAGE;
import static lotto.constant.OutputConstant.LOTTO_QUANTITY_MESSAGE;
import static lotto.constant.OutputConstant.LOTTO_STAT_INTRO_MESSAGE;
import static lotto.constant.OutputConstant.MATCH_MESSAGE;
import static lotto.constant.OutputConstant.PRIZE_MESSAGE;
import static lotto.constant.OutputConstant.PROFIT_MESSAGE;

import java.util.List;
import lotto.Lotto;
import lotto.constant.MatchingType;
import lotto.constant.PrizeType;
import lotto.Profit;
import lotto.Quantity;
import lotto.WinningStat;

public class OutputView {

    public static void printLottoQuantity(Quantity quantity) {
        String result = String.format(LOTTO_QUANTITY_MESSAGE.getMessage(), quantity.getNumber());

        System.out.println(result);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printStatistics(List<WinningStat> winningStats) {
        System.out.println(LOTTO_STAT_INTRO_MESSAGE.getMessage());
        System.out.println(DIVIDING_LINE_MESSAGE.getMessage());

        for (WinningStat winningStat : winningStats) {
            MatchingType matchingType = winningStat.getMatchingType();
            PrizeType prizeType = matchingType.getPrizeType();
            int count = winningStat.getCount();
            String result = makeStatSentence(matchingType, prizeType, count);

            System.out.println(result);
        }
    }

    private static String makeStatSentence(MatchingType matchingType, PrizeType prizeType, int count) {
        String matchMessage = String.format(MATCH_MESSAGE.getMessage(), matchingType.getMatchCount());

        String prizeMessage = String.format(PRIZE_MESSAGE.getMessage(), prizeType.getMoney());
        if (matchingType == MatchingType.FIVE_WITH_BONUS_MATCH) {
            prizeMessage = BONUS_PRIZE_MESSAGE.getMessage().concat(prizeMessage);
        }

        String countMessage = String.format(COUNT_MESSAGE.getMessage(), count);

        return matchMessage + prizeMessage + countMessage;
    }

    public static void printProfit(Profit profit, Quantity quantity) {
        double profitPercent = profit.calculate(quantity);
        String result = String.format(PROFIT_MESSAGE.getMessage(), profitPercent);
        System.out.println(result);
    }
}
