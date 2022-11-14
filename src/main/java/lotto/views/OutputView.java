package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.message.OutputMessage;

public class OutputView {
    public static final int COUNT_OF_LOTTO = 0;
    public static final int BOUGHT_RESULT_MESSAGE = 1;
    public static final int STATISTICS = 0;
    public static final int EARNINGS_RATE = 1;
    public static final int WIN_RESULT_COUNT = 5;
    public static final String NEXT_LINE = "\n";
    public static final int ZERO_WIN = 0;


    public void outputLottoBuyingResult(List<String> resultOfBuyingLotto) {
        System.out.println();
        System.out.println(resultOfBuyingLotto.get(COUNT_OF_LOTTO) + OutputMessage.BOUGHT_MESSAGE);
        System.out.println(resultOfBuyingLotto.get(BOUGHT_RESULT_MESSAGE));
    }

    public void printLottoResult(List<Object> lottoResult) {
        System.out.println();
        System.out.println(OutputMessage.WINNING_STATISTICS);
        System.out.println(OutputMessage.DIVIDING_LINE);
        System.out.println(createStatisticsMessage(lottoResult.get(STATISTICS)));
        System.out.println(createEarningsRateMessage((double) lottoResult.get(EARNINGS_RATE)));
    }

    private String createStatisticsMessage(Object statistics) {
        StringBuilder statisticsMessage = new StringBuilder();
        List<WinResultStatus> winResultStatuses = WinResultStatus.getWinResultStatuses();
        Map<WinResultStatus, Integer> statisticsCounts = (Map<WinResultStatus, Integer>) statistics;
        for (int winResultIndex = 0; winResultIndex < WIN_RESULT_COUNT; winResultIndex++) {
            statisticsMessage.append(fillMessageFormat(winResultIndex, winResultStatuses.get(winResultIndex), statisticsCounts))
                    .append(NEXT_LINE);
        }
        return statisticsMessage.deleteCharAt(statisticsMessage.lastIndexOf(NEXT_LINE))
                .toString();
    }

    private String fillMessageFormat(int winResultIndex,
                                     WinResultStatus winResultStatus,
                                     Map<WinResultStatus, Integer> statisticsCounts) {
        if (statisticsCounts.containsKey(winResultStatus)) {
            return String.format(getStatisticsFormat(winResultIndex), statisticsCounts.get(winResultStatus));
        }
        return String.format(getStatisticsFormat(winResultIndex), ZERO_WIN);
    }

    private static String getStatisticsFormat(int winResultIndex) {
        return OutputMessage.STATISTICS_FORMATS
                .get(winResultIndex);
    }

    private String createEarningsRateMessage(final double earningsRate) {
        return String.format(OutputMessage.EARNINGS_RATIO_FORMAT, earningsRate);
    }
}
