package lotto.view;


import lotto.model.LottoResult;
import lotto.model.Prize;

import java.util.Map;

public class LottoResultView {
    public static void outPut(LottoResult lottoResult){
        Map<Prize, Integer> statistics = lottoResult.getStatistics();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(Prize.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(Prize.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(Prize.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(Prize.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(Prize.FIRST) + "개");
    }
}
