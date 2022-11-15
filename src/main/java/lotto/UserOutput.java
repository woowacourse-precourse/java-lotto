package lotto;

import java.util.List;
import java.util.Map;

import static lotto.Buyer.LOTTO_PRICE;

public class UserOutput {
    private static final String BUY_LOTTO_COUNT_MSG = "개를 구매했습니다.";
    private static final String WINNING_STATS_MSG = "당첨통계\n---";
    private static final String WINNING_STATS_DETAIL_MSG = "%s - %d개%n";
    private static final String WINNING_RATE_MSG = "총 수익률은 %.1f%%입니다.%n";

    public static void printLottoCount(int amount){
        System.out.println((amount/LOTTO_PRICE)+BUY_LOTTO_COUNT_MSG);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStats(Map<Rank,Integer> winningBoard) {
        System.out.println(WINNING_STATS_MSG);

        System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_5.getNotification(),winningBoard.getOrDefault(Rank.RANK_5,0));
        System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_4.getNotification(),winningBoard.getOrDefault(Rank.RANK_4,0));
        System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_3.getNotification(),winningBoard.getOrDefault(Rank.RANK_3,0));
        System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_2.getNotification(),winningBoard.getOrDefault(Rank.RANK_2,0));
        System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_1.getNotification(),winningBoard.getOrDefault(Rank.RANK_1,0));


        if(0 < winningBoard.get(Rank.RANK_2)){
            System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_2.getNotification(),winningBoard.get(Rank.RANK_2) );
        }

        if(0 < winningBoard.get(Rank.RANK_1)){
            System.out.printf(WINNING_STATS_DETAIL_MSG,Rank.RANK_1.getNotification(),winningBoard.get(Rank.RANK_1) );
        }
    }

    public static void printWinningRate(double rate){
        System.out.printf(WINNING_RATE_MSG,rate);
    }
}
