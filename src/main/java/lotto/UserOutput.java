package lotto;

import java.util.List;
import java.util.Map;

public class UserOutput {
    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨통계%n---";
    private static final String WINNING_STATS_DETAIL_MESSAGE = "%s - %d개%n";
    private static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f %%입니다.%n";

    public static void printLottoCount(int count) {
        System.out.println(count + BUY_LOTTO_COUNT_MESSAGE);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStats(Map<Rank,Integer> winningBoard) {
        System.out.println(WINNING_STATS_MESSAGE);

        if(0 < winningBoard.get(Rank.RANK_5)){
            System.out.printf(WINNING_STATS_DETAIL_MESSAGE,Rank.RANK_5.getNotification(),winningBoard.get(Rank.RANK_5) );
        }

        if(0 < winningBoard.get(Rank.RANK_4)){
            System.out.printf(WINNING_STATS_DETAIL_MESSAGE,Rank.RANK_4.getNotification(),winningBoard.get(Rank.RANK_4) );
        }

        if(0 < winningBoard.get(Rank.RANK_3)){
            System.out.printf(WINNING_STATS_DETAIL_MESSAGE,Rank.RANK_3.getNotification(),winningBoard.get(Rank.RANK_3) );
        }

        if(0 < winningBoard.get(Rank.RANK_2)){
            System.out.printf(WINNING_STATS_DETAIL_MESSAGE,Rank.RANK_2.getNotification(),winningBoard.get(Rank.RANK_2) );
        }

        if(0 < winningBoard.get(Rank.RANK_1)){
            System.out.printf(WINNING_STATS_DETAIL_MESSAGE,Rank.RANK_1.getNotification(),winningBoard.get(Rank.RANK_1) );
        }
    }

    public static void printWinningRate(double rate){
        System.out.printf(WINNING_RATE_MESSAGE,rate);
    }
}
