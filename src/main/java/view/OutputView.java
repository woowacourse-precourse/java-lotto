package view;

import lotto.Lotto;
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

    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d" + YOU_BOUGHT_SOME + "\n", lottos.size());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printResultOfLotto(Map<LottoGrade, Integer> resultOfLotto, Double rateOfReturn) {
        System.out.println();
        System.out.println(RESULT_OF_LOTTO);
        System.out.printf(FIFTH + "%d" + "개\n", resultOfLotto.get(LottoGrade.FIFTH));
        System.out.printf(FOURTH + "%d" + "개\n", resultOfLotto.get(LottoGrade.FOURTH));
        System.out.printf(THIRD + "%d" + "개\n", resultOfLotto.get(LottoGrade.THIRD));
        System.out.printf(SECOND + "%d" + "개\n", resultOfLotto.get(LottoGrade.SECOND));
        System.out.printf(FIRST + "%d" + "개\n", resultOfLotto.get(LottoGrade.FIRST));
        System.out.printf("총 수익률은 " + "%.1f%%" + "입니다.", rateOfReturn);
    }
}
