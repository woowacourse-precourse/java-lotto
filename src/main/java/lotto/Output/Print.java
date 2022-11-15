package lotto.Output;

import lotto.Lotto;
import lotto.Constant.Ranking;
import java.util.List;
import java.util.HashMap;

public class Print {
    public static void LottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList)
            lotto.print();
    }

    public static void Result(HashMap<Ranking, Integer> lottoRankInfo){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoRankInfo.get(Ranking.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRankInfo.get(Ranking.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRankInfo.get(Ranking.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankInfo.get(Ranking.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRankInfo.get(Ranking.FIRST) + "개");
    }

    public static void EarningRate(int cashprize, int inputmoney){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double)cashprize / inputmoney*100);
    }
}
