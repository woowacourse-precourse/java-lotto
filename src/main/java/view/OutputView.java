package view;

import lotto.Lotto;
import lotto.LottoCollection;
import lotto.LottoCount;
import lotto.LottoRank;
import lotto.constant.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static String PRINT_NUMBER_OF_LOTTO_COUNT = "%d개를 구매했습니다";
    private static String PRINT_WINNING_HISTORY_START = "당첨 통계\n---";
    private static String PRINT_RANK_STATUS = "%d개 일치%s (%s원) - %d개";

    public static void printLottoCount(LottoCount count) {
        System.out.printf(PRINT_NUMBER_OF_LOTTO_COUNT, count.getLottoCount());
        System.out.println();
    }
    public static void printLottoCollection(LottoCollection lottoCollection){
        for (Lotto lotto : lottoCollection.copyCollection()) {
            System.out.println(lotto.copyNumbers());
        }
    }
    public static void printWinningResult(LottoRank lottoRank){
        System.out.println(PRINT_WINNING_HISTORY_START);
        printWinningHistory(lottoRank);
    }
    private static void printWinningHistory(LottoRank lottoRank){
        DecimalFormat df = new DecimalFormat("###,###");

        List<Rank> reversedRank = lottoRank.reverseByReward();
        for (Rank rank : reversedRank) {
            System.out.printf(PRINT_RANK_STATUS, rank.getMatchCount(), classifyRankSecond(rank), df.format(rank.getReward()), lottoRank.getRankCount(rank));
            System.out.println();
        }
    }
    private static String classifyRankSecond(Rank rank) {
        if (!rank.equals(Rank.SECOND_PLACE)) {
            return "";
        }
        return ", 보너스 볼 일치 ";
    }
}

