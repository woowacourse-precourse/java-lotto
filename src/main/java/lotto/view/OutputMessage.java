package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class OutputMessage {
    public static void purchaseComplete(int count){
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void lottoNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }

    public static void winningStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void showRankResult(HashMap<Rank, Integer> map){
        for(Rank rank : Rank.values()){
            showSingleRankResult(map, rank);
        }
    }

    private static void showSingleRankResult(HashMap<Rank, Integer> map, Rank rank){
        if(rank.equals(Rank.NO_RANK)){
            return;
        }
        if(rank.equals(Rank.SECOND)){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",rank.getCount(), rank.getConvertPrize(), map.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n",rank.getCount(), rank.getConvertPrize(), map.get(rank));
    }

    public static void showYieldResult(double yield){
        System.out.printf("총 수익률은 %.1f%%입니다.",yield);
    }
}
