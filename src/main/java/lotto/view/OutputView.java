package lotto.view;

import lotto.model.Lotto;
import java.util.List;
import static lotto.utils.PrizeInfo.*;

public class OutputView {
    private static final String OUTPUT_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계\n" + "---";
    private static final String OUTPUT_RESULT_LAST_LETTER = "개";
    private static final String OUTPUT_EARNING_RATE_FORMER = "총 수익률은 ";
    private static final String OUTPUT_EARNING_RATE_LATTER = "%입니다.";

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
        System.out.println(PRIZE5.getOutputMessage() + ranks[5] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(PRIZE4.getOutputMessage() + ranks[4] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(PRIZE3.getOutputMessage() + ranks[3] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(PRIZE2.getOutputMessage() + ranks[2] + OUTPUT_RESULT_LAST_LETTER);
        System.out.println(PRIZE1.getOutputMessage() + ranks[1] + OUTPUT_RESULT_LAST_LETTER);
    }

    public void outputEarningRate(double earningRate) {
        System.out.println(OUTPUT_EARNING_RATE_FORMER + earningRate + OUTPUT_EARNING_RATE_LATTER);
    }
}
