package lotto.veiw;

import static lotto.domain.LottoReference.NOPE;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReference;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoResult;

public class OutputHandler {

    public void winningStatistics(LottoResult lottoResult) {
        Map<LottoReference, Integer> result = lottoResult.getValue();
        DecimalFormat moneyFormat = new DecimalFormat("###,###");

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoReference lo : LottoReference.values()) {
            if (lo == NOPE) {
                continue;
            }
            System.out.printf("%d개 일치%s (%s원) - %d개\n", lo.getCorrectCount(), lo.getMessage(),
                    moneyFormat.format(lo.getPrize()),
                    result.getOrDefault(lo, 0));
        }
    }

    public void printYield(LottoResult lottoResult) {
        Map<LottoReference, Integer> result = lottoResult.getValue();
        DecimalFormat floatFormat = new DecimalFormat("###,###.#");

        float lottoYield = LottoReference.getYield(result);
        System.out.printf("총 수익률은 %s%%입니다.\n", floatFormat.format(lottoYield));
    }

    public void printBuyLottoList(LottoMachine lottoMachine) {
        System.out.println(lottoMachine.getBuyLotteries().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoMachine.getBuyLotteries()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
