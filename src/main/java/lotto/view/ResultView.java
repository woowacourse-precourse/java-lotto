package lotto.view;

import lotto.domain.Rank;
import lotto.domain.RankResult;

import java.util.List;

import static lotto.utils.Messages.PRINT_BONUS_MESSAGE;
import static lotto.utils.Messages.PRINT_NOT_BONUS_MESSAGE;
import static lotto.utils.Messages.PRINT_PROFIT_MESSAGE;
import static lotto.utils.Messages.PRINT_PURCHASE_COUNT_MESSAGE;
import static lotto.utils.Messages.PRINT_RANK_MATCHCOUNT_MESSAGE;
import static lotto.utils.Messages.PRINT_RANK_WINMONEY_AND_COUNT_MESSAGE;
import static lotto.utils.Messages.PRINT_RESULT_START_MESSAGE;

public class ResultView {

    public static void printRandomLottos(List<List<Integer>> lottos, int purchase) {
        System.out.printf(PRINT_PURCHASE_COUNT_MESSAGE,purchase);
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(RankResult rankResult) {
        System.out.printf(PRINT_RESULT_START_MESSAGE);
        for (Rank rank : rankResult.getResult().keySet()) {
            int value = rankResult.getResult().get(rank);
            System.out.printf(printRank(rank, value));
        }
    }

    private static String printRank(Rank rank, int count) {
        StringBuilder message = new StringBuilder();
        if (!rank.equals(Rank.LOSER)) {
            message.append(String.format(PRINT_RANK_MATCHCOUNT_MESSAGE, rank.getMatchCount()));
            message.append(printBonusNumber(rank));
            message.append(String.format(PRINT_RANK_WINMONEY_AND_COUNT_MESSAGE, rank.getStringWinMoney(), count));
        }
        return message.toString();
    }

    private static String printBonusNumber(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return PRINT_BONUS_MESSAGE;
        }
        return PRINT_NOT_BONUS_MESSAGE;
    }

    public static void printProfit(RankResult rankResult, int money) {
        System.out.printf(PRINT_PROFIT_MESSAGE, rankResult.getProfit(money));
    }
}
