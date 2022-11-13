package view;

import type.LottoGrade;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String YOU_BOUGHT_SOME = "개를 구매했습니다.";
    private static final String RESULT_OF_LOTTO = "당첨 통계\n---";
    private static final String FIFTH = "3개 일치 (5,000원) - ";
    private static final String FOURTH = "4개 일치 (50,000원) - ";
    private static final String THIRD = "5개 일치 (1,500,000원) - ";
    private static final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST = "6개 일치 (2,000,000,000원) - ";

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(YOU_BOUGHT_SOME);
        lottoNumbers.forEach(System.out::println);
    }

    public static void printResultOfLotto(Map<LottoGrade, Integer> lottoGrade, Long rateOfReturn) {
        System.out.println(RESULT_OF_LOTTO);
        System.out.printf(FIFTH + "%d" + "개\n", lottoGrade.get(LottoGrade.FIFTH));
        System.out.printf(FOURTH + "%d" + "개\n", lottoGrade.get(LottoGrade.FOURTH));
        System.out.printf(THIRD + "%d" + "개\n", lottoGrade.get(LottoGrade.THIRD));
        System.out.printf(SECOND + "%d" + "개\n", lottoGrade.get(LottoGrade.SECOND));
        System.out.printf(FIRST + "%d" + "개\n", lottoGrade.get(LottoGrade.FIRST));
        System.out.printf("총 수익률은 " + "%d" + "입니다.", rateOfReturn);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
