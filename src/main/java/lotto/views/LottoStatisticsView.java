package lotto.views;

import lotto.domain.lottoResult.LottoRank;

public class LottoStatisticsView {
    public static void printLottoWinResult(){
        System.out.println("당첨 통계\n---");

        for(LottoRank rank: LottoRank.values()){
            if(rank == LottoRank.NO_PRIZE){
                break;
            }
            System.out.println(rank.toString());
        }
    }

    public static void printLottoYield(double lottoYield){
        System.out.println("총 수익률은 "+lottoYield+"%입니다.");
    }
}
