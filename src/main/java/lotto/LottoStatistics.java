package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoStatistics {
    public static List<Integer> resultWinningLottery(List<Lotto> lotto, List<Integer> winningNumber, Integer bonusNumber){
        List<Integer> lottoResult = Arrays.asList(0,0,0,0,0);

        int rank;
        for(int i = 0 ; i < lotto.size() ; i++) {
            rank = lotto.get(i).lottoRanking(winningNumber,bonusNumber);
            if( rank != 0 )
                lottoResult.set( rank-1 , lottoResult.get(rank-1) + 1 );
        }

        return lottoResult;
    }
    public static double calculateLottoEarningsRate(List<Integer> lottoResult, int lottoCount){
        double purchaseAmount = lottoCount * 1000;
        double earning = 0;

        String rank;
        for(int i = 0 ; i < lottoResult.size() ; i++){
            rank = "RANK"+(i+1);
            earning += lottoResult.get(i) * LottoInformation.valueOf(rank).getPrizeMoney();
        }

        double earningRate = earning / purchaseAmount * 100;
        earningRate = Math.round(earningRate*10) / 10.0;

        return earningRate;
    }
    public static void winningStatistics(List<Integer> lottoResult, double earningRate){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        String rank;
        for(int i = lottoResult.size()-1 ; i >= 0 ; i--) {
            rank = "RANK" + (i + 1);
            System.out.print(LottoInformation.valueOf(rank).getResultMsg());
            System.out.println(" - " + lottoResult.get(i)+"개");
        }
        System.out.println("총 수익률은 "+earningRate+"%입니다.");
    }
}
