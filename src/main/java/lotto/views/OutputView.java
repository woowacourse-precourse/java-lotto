package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.message.InputMessage;
import lotto.constants.message.OutputMessage;

public class OutputView {
    public static final int COUNT_OF_LOTTO = 0;
    public static final int BOUGHT_RESULT_MESSAGE = 1;
    public static final int STATISTICS = 0;
    public static final int EARNINGS_RATE = 1;


    public void outputLottoBuyingResult(List<String> resultOfBuyingLotto) {
        System.out.println();
        System.out.println(resultOfBuyingLotto.get(COUNT_OF_LOTTO) + OutputMessage.BOUGHT_MESSAGE);
        System.out.println(resultOfBuyingLotto.get(BOUGHT_RESULT_MESSAGE));
    }

    public void printLottoResult(List<Object> lottoResult) {
        System.out.println();
        System.out.println(createStatisticsMessage(lottoResult.get(STATISTICS)));
        System.out.println(createEarningsRateMessage((double) lottoResult.get(EARNINGS_RATE)));
    }

    private String createStatisticsMessage(Object statistics) {
        return "";
    }

    private String createEarningsRateMessage(final double earningsRate) {
        return String.format(OutputMessage.EARNINGS_RATIO_MESSAGE, earningsRate);
    }
}
