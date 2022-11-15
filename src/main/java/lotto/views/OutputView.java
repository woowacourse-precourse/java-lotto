package lotto.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.message.OutputMessage;
import lotto.domain.Lotto;

public class OutputView {
    public static final int COUNT_OF_LOTTO = 0;
    public static final int BOUGHT_RESULT = 1;
    public static final int STATISTICS = 0;
    public static final int EARNINGS_RATE = 1;
    public static final int WIN_RESULT_COUNT = 5;
    public static final String NEXT_LINE = "\n";
    public static final int ZERO_WIN = 0;
    public static final String PRICE_FORMAT = "#,##0.0";
    private static final int ONE = 1;

    public void outputLottoBuyingResult(List<Object> resultOfBuyingLotto) {
        System.out.println();
        System.out.println(createBuyingLottoCountMessage((int) resultOfBuyingLotto.get(COUNT_OF_LOTTO)));
        System.out.println(createBuyingLottoResultMessage((List<Lotto>)resultOfBuyingLotto.get(BOUGHT_RESULT)));
    }

    private String createBuyingLottoResultMessage(List<Lotto> buyingLottos) {
        StringBuilder allLottoNumber = new StringBuilder();
        buyingLottos.stream()
                .map(Lotto::createMessage)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(NEXT_LINE));
        return allLottoNumber.deleteCharAt(allLottoNumber.length() - ONE)
                .toString();
    }

    private String createBuyingLottoCountMessage(int buyingLottoCount) {
        return String.format(OutputMessage.BOUGHT_FORMAT, buyingLottoCount);
    }

    public void printLottoResult(List<Object> lottoResult) {
        System.out.println();
        System.out.println(OutputMessage.WINNING_STATISTICS);
        System.out.println(OutputMessage.DIVIDING_LINE);
        System.out.println(createStatisticsMessage(lottoResult.get(STATISTICS)));
        System.out.println(createEarningsRateMessage((double) lottoResult.get(EARNINGS_RATE)));
    }

    private String createStatisticsMessage(Object statistics) {
        // TODO 리팩토링
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
        NumberFormat decimalFormat = new DecimalFormat(PRICE_FORMAT);
        String format = decimalFormat.format(earningsRate);
        return String.format(OutputMessage.EARNINGS_RATIO_FORMAT, format);
    }
}
