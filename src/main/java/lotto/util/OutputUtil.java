package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.enums.Constant;
import lotto.domain.enums.Number;

import java.util.List;
import java.util.Map;

public class OutputUtil {

    private final String RESULT_FIFTH = "3개 일치 (5,000원) - ";
    private final String RESULT_FOURTH = "4개 일치 (50,000원) - ";
    private final String RESULT_THIRD = "5개 일치 (1,500,000원) - ";
    private final String RESULT_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String RESULT_FIRST = "6개 일치 (2,000,000,000원) - ";

    public void printUserLottoCount(int lottoCount) {
        System.out.println("" + lottoCount + "개를 구매했습니다.");
    }

    public void printUserLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Number, Integer> ranks) {
        System.out.println(RESULT_FIFTH + ranks.get(Number.FIVE) + "개");
        System.out.println(RESULT_FOURTH + ranks.get(Number.FOUR) + "개");
        System.out.println(RESULT_THIRD + ranks.get(Number.THREE) + "개");
        System.out.println(RESULT_SECOND + ranks.get(Number.TWO) + "개");
        System.out.println(RESULT_FIRST + ranks.get(Number.ONE) + "개");
    }
}
