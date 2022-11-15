package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String LEFT_BRACKET="[";
    private static final String RIGHT_BRACKET="] \n";
    private static final String COMMA=", ";
    private static final String PURCHASE_MESSAGE="\n %d개를 구매했습니다.\n";
    private static final String UNIT="개";
    private static final String ALL_RESULT="당첨 통계";
    private static final String DIVISOR="---";
    private static final String RESULT_FIFTH="3개 일치 (5,000원) - ";
    private static final String RESULT_FOURTH="4개 일치 (50,000원) - ";
    private static final String RESULT_THIRD="5개 일치 (1,500,000원) - ";
    private static final String RESULT_SECOND="5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String RESULT_FIRST="6개 일치 (2,000,000,000원) - ";

    public static void printPurchaseLottoSet(int purchaseLottoSet) {
        System.out.printf(PURCHASE_MESSAGE, purchaseLottoSet);
    }

    public static void printPurchaseLottoNumbers(List<Lotto> lottoNumbers) {
        int i, j;
        for (i = 0; i < lottoNumbers.size(); i++) {
            System.out.print(LEFT_BRACKET);
            List<Integer> lottoOneSetNumbers = new ArrayList<>(lottoNumbers.get(i).getNumbers());
            for (j = 0; j < 5; j++) {
                System.out.print(lottoOneSetNumbers.get(j) + COMMA);
            }
            System.out.print(lottoOneSetNumbers.get(j) + RIGHT_BRACKET);
        }
        System.out.println();
    }

    public static void printLottoResult(Map<LottoRanking, Integer> lottoResult) {
        System.out.println(ALL_RESULT);
        System.out.println(DIVISOR);
        System.out.println(RESULT_FIFTH + lottoResult.get(LottoRanking.FIFTH) + UNIT);
        System.out.println(RESULT_FOURTH + lottoResult.get(LottoRanking.FOURTH) + UNIT);
        System.out.println(RESULT_THIRD + lottoResult.get(LottoRanking.THIRD) + UNIT);
        System.out.println(RESULT_SECOND + lottoResult.get(LottoRanking.SECOND) + UNIT);
        System.out.println(RESULT_FIRST + lottoResult.get(LottoRanking.FIRST) + UNIT);
    }

    public static void printLottoProfitRate(double profitRate) {
        System.out.printf(PROFIT_MESSAGE, profitRate);
    }
}
