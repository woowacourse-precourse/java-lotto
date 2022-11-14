package lotto;

import java.util.List;

public class ResultView {

    private static final String PRINT_RANK_MATCHCOUNT_MESSAGE = "%d개 일치";
    private static final String PRINT_RANK_WINMONEY_AND_COUNT_MESSAGE = " (%d원) - %d개\n";
    private static final String PRINT_NOT_BALL_MESSAGE = "";
    private static final String PRINT_BALL_MESSAGE = ", 보너스 볼 일치";

    public void printRandomLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(RankResult rankResult) {
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
            message.append(String.format(PRINT_RANK_WINMONEY_AND_COUNT_MESSAGE, rank.getWinMoney(), count));
        }
        return message.toString();
    }

    private static String printBonusNumber(Rank rank) {
        if (rank.isSecond()) {
            return PRINT_BALL_MESSAGE;
        }
        return PRINT_NOT_BALL_MESSAGE;
    }
}
