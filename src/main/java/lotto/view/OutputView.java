package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStatics;
import lotto.model.Winning;

public class OutputView {
    private static final String MESSAGE_COUNT_BUY = "%d개를 구매했습니다.\n";
    private static final String MESSAGE_STATICS_START = "당첨 통계\n---\n";
    private static final String MESSAGE_STATICS_INFO = "%s (%,d원) - %d개\n";
    private static final String MESSAGE_YIELD = "총 수익률은 %.1f%%입니다.";

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(MESSAGE_COUNT_BUY, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinnings(LottoStatics statics) {
        HashMap<Winning, Integer> staticsInfo = statics.getStaticsInfo();

        System.out.printf(MESSAGE_STATICS_START);
        for (Winning value : Winning.values()) {
            if (value.getPrize() != 0) {
                System.out.printf(MESSAGE_STATICS_INFO, value.getDetail(), value.getPrize(), staticsInfo.get(value));
            }
        }
    }

    public static void printYield(int inputmoney, LottoStatics statics) {
        BigDecimal money = new BigDecimal(String.valueOf(inputmoney));
        BigDecimal totalPrize = statics.getTotalPrize();

        BigDecimal yield = totalPrize.divide(money, 3, RoundingMode.HALF_UP);
        yield = yield.multiply(new BigDecimal("100"));

        System.out.printf(MESSAGE_YIELD, yield);
    }
}
