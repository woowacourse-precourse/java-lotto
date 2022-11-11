package lotto.view;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printPurchaseLottoSet(int purchaseLottoSet) {
        System.out.println(purchaseLottoSet + "개를 구매했습니다.");
    }

    public static void printPurchaseLottoNumbers(List<Lotto> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println("[");
           // for(int j=0;j< 6; j++)
               // System.out.println(lottoNumbers.get(i). + "]");
            //System.out.println(lottoNumbers.get(i)[lottoNumbers[i].length - 1] + "]");
        }
    }

    public static void printLottoResult(List<Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) -" + lottoResult.get(0) + "개");
        System.out.println("4개 일치 (50,000원) -" + lottoResult.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) -" + lottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + lottoResult.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) -" + lottoResult.get(4) + "개");
    }

    public static void printLottoProfitRate(float profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
