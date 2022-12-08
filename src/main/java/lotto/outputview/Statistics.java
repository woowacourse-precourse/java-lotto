package lotto.outputview;

import lotto.lotto.LottoRank;

public class Statistics {
    public static void printWin() {
        System.out.println("당첨 통계\n--");
        for(LottoRank lottoRank : LottoRank.values()) {
            System.out.println(lottoRank);
        }
    }
    public static void printRevenue(double result) {
        System.out.println("총 수익률은 " + String.format("%.1f", result) +"%입니다.");
    }
}
