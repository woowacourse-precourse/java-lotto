package lotto.views;

import lotto.domain.LottoRank;

public class LottoStatisticsView {
    public static void printLottoWinResult(){
        System.out.println("당첨 통계\n---");
        for(LottoRank rank: LottoRank.values()){
            System.out.println(rank.toString());
        }
    }
}
