package lotto.veiw;

import static lotto.domain.LottoReference.NOPE;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.LottoReference;

public class OutputHandler {

    public void winningStatistics(Map<LottoReference, Integer> result) {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoReference lo : LottoReference.values()) {
            if (lo != NOPE) {
                System.out.printf("%d개 일치%s (%s원) - %d개\n", lo.getCorrectCount(), lo.getMessage(),
                        moneyFormat.format(lo.getPrize()),
                        result.getOrDefault(lo, 0));
            }
        }
    }

    public void printYield(float yield) {
        DecimalFormat floatFormat = new DecimalFormat("###,###.#");
        System.out.printf("총 수익률은 %s%%입니다.\n", floatFormat.format(yield));
    }
}
