package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계\n" + "---";
    private static final String OUTPUT_RESULT_1ST_PRIZE = "6개 일치 (2,000,000,000원) - ";
    private static final String OUTPUT_RESULT_2ND_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String OUTPUT_RESULT_3RD_PRIZE = "5개 일치 (1,500,000원) - ";
    private static final String OUTPUT_RESULT_4TH_PRIZE = "4개 일치 (50,000원) - ";
    private static final String OUTPUT_RESULT_5TH_PRIZE = "3개 일치 (5,000원) - ";
    private static final String OUTPUT_RESULT_LAST_LETTER = "개";

    public void outputUserLottos(List<Lotto> userLottos) {
        System.out.println();
        System.out.println(userLottos.size() + OUTPUT_PURCHASE_MESSAGE);
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputLottoResult(int[] ranks) {
        System.out.println();
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(OUTPUT_RESULT_5TH_PRIZE + ranks[5] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(OUTPUT_RESULT_4TH_PRIZE + ranks[4] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(OUTPUT_RESULT_3RD_PRIZE + ranks[3] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(OUTPUT_RESULT_2ND_PRIZE + ranks[2] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(OUTPUT_RESULT_1ST_PRIZE + ranks[1] + OUTPUT_RESULT_LAST_LETTER);
    }
}
