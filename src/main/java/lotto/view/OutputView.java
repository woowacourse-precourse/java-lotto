package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS = "%d개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String LINE = "---";
    private static final String RANKING_INFO = "%d개 일치%s (%,d원) - %d개";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String YIELD = "총 수익률은 %s%%입니다.";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = "";

    public static void printResult(Map<Ranking, Integer> numberOfLottosByRank, double yield) {
        printWinningStats(numberOfLottosByRank);
        printYield(yield);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(NUMBER_OF_LOTTOS + NEW_LINE, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.printf(NEW_LINE);
    }

    public static void printWinningStats(Map<Ranking, Integer> numberOfLottosByRank) {
        System.out.println(WINNING_STATS);
        System.out.println(LINE);
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.NOT_RANKED) {
                continue;
            }
            int count = numberOfLottosByRank.get(ranking);
            printRankingInfo(ranking, count);
        }
    }

    public static void printYield(double yield) {
        System.out.printf(YIELD, yield);
    }

    private static void printRankingInfo(Ranking ranking, int count) {
        String bonusBallMatch = EMPTY_STRING;
        if (ranking == Ranking.SECOND_PLACE) {
            bonusBallMatch = BONUS_BALL_MATCH;
        }
        int matchNumber = ranking.getNumberOfMatchNumbers();
        int winnings = ranking.getReward();
        System.out.printf(RANKING_INFO + NEW_LINE, matchNumber, bonusBallMatch, winnings, count);
    }
}
