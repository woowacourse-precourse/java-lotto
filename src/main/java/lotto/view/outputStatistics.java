package lotto.view;

import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;

import java.util.Arrays;

public class outputStatistics {
    private static final String NEWLINE = "\n";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f입니다.";

    static PrizeResult prizeResult;

    private static void printStatistics(double rate) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.EMPTY))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate);
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , prize.getMatchLottoNumber()
                    , prize.getMoney()
                    , prizeResult.getPrizeCount(prize));
        }

        return String.format(OUTPUT_RESULT_MESSAGE
                , prize.getMatchLottoNumber()
                , prize.getMoney()
                , prizeResult.getPrizeCount(prize));
    }
}
