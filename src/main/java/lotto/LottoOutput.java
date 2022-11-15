package lotto;

import java.util.List;

public class LottoOutput {
    private static String BUY_LOTTERY_OUTPUT = "개를 구매했습니다.";
    private static String STATISTIC_COMMENT = "당첨 통계\n---";
    private static String RANK_INFORMATION_OUTPUT = "%s (%s원) - %d개";
    private static String STATISTICS_OUTPUT = "총 수익률은 %.1f%%입니다.";

    public static void printLottery(List<Lotto> lotteries){
        System.out.println();
        System.out.println(lotteries.size() + BUY_LOTTERY_OUTPUT);
        for(Lotto lottery : lotteries){
            System.out.println(lottery.getNumbers());
        }
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult, int bonusNumber){
        System.out.println(STATISTIC_COMMENT);
        for(LottoRank rank: LottoRank.values()){
            if(rank.getRank() ==0) continue;
            System.out.println();
        }
    }
}
