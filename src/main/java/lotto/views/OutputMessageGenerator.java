package lotto.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinningResultStatus;
import lotto.constants.messages.OutputMessage;
import lotto.constants.utils.MessageFormatUtil;
import lotto.domain.Lotto;

public class OutputMessageGenerator {
    public static final int WIN_RESULT_COUNT = 5;
    public static final int ZERO_WIN = 0;

    public String createBuyingLottoResultMessage(List<Lotto> buyingLottos) {
        StringBuilder allLottoNumber = new StringBuilder();
        appendBuyingLottos(buyingLottos, allLottoNumber);
        return deleteLastSeparator(allLottoNumber);
    }

    private static void appendBuyingLottos(List<Lotto> buyingLottos, StringBuilder allLottoNumber) {
        buyingLottos.stream()
                .map(Lotto::createMessage)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(MessageFormatUtil.NEXT_LINE));
    }

    public String createBuyingLottoCountMessage(int buyingLottoCount) {
        return String.format(OutputMessage.BOUGHT_FORMAT, buyingLottoCount);
    }

    public String createStatisticsMessage(Map<WinningResultStatus, Integer> statisticsCounts) {
        StringBuilder statisticsMessage = new StringBuilder();
        appendStatisticsCounts(statisticsCounts, statisticsMessage);
        return deleteLastSeparator(statisticsMessage);
    }

    private void appendStatisticsCounts(Map<WinningResultStatus, Integer> statisticsCounts,
                                        StringBuilder statisticsMessage) {
        List<WinningResultStatus> winningResults = WinningResultStatus.getWinResultStatuses();
        for (int winResultIndex = 0; winResultIndex < WIN_RESULT_COUNT; winResultIndex++) {
            statisticsMessage.append(
                            fillMessageFormat(winResultIndex, winningResults.get(winResultIndex), statisticsCounts))
                    .append(MessageFormatUtil.NEXT_LINE);
        }
    }

    private String fillMessageFormat(int winResultIndex,
                                     WinningResultStatus winningResult,
                                     Map<WinningResultStatus, Integer> statisticsCounts) {
        if (statisticsCounts.containsKey(winningResult)) {
            return String.format(getStatisticsFormat(winResultIndex), statisticsCounts.get(winningResult));
        }
        return String.format(getStatisticsFormat(winResultIndex), ZERO_WIN);
    }

    private static String getStatisticsFormat(int winResultIndex) {
        return OutputMessage.STATISTICS_FORMATS
                .get(winResultIndex);
    }

    public String createEarningsRateMessage(final double earningsRate) {
        NumberFormat decimalFormat = new DecimalFormat(MessageFormatUtil.PRICE_FORMAT);
        String format = decimalFormat.format(earningsRate);
        return String.format(OutputMessage.EARNINGS_RATIO_FORMAT, format);
    }

    private String deleteLastSeparator(StringBuilder allLottoNumber) {
        return allLottoNumber.deleteCharAt(allLottoNumber.lastIndexOf(MessageFormatUtil.NEXT_LINE))
                .toString();
    }
}
