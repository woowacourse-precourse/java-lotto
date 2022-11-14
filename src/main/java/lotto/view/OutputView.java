package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다";

    public static void printPurchaseLottoSet(int purchaseLottoSet) {
        System.out.println("\n" + purchaseLottoSet + "개를 구매했습니다.");
    }

    public static void printPurchaseLottoNumbers(List<Lotto> lottoNumbers) {
        int i, j;
        for (i = 0; i < lottoNumbers.size(); i++) {
            System.out.print("[");
            List<Integer> lottoOneSetNumbers = new ArrayList<>(lottoNumbers.get(i).getNumbers());
            for (j = 0; j < 5; j++) {
                System.out.print(lottoOneSetNumbers.get(j) + ", ");
            }
            System.out.print(lottoOneSetNumbers.get(j) + "] \n");
        }
        System.out.println();
    }

    public static void printLottoResult(Map<LottoRanking, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(LottoRanking.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(LottoRanking.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(LottoRanking.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(LottoRanking.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(LottoRanking.FIRST) + "개");
    }

    public static void printLottoProfitRate(double profitRate) {
        System.out.printf(PROFIT_MESSAGE, profitRate);
    }
}
