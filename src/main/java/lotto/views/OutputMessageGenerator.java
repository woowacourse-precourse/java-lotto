package lotto.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.messages.OutputMessage;
import lotto.constants.utils.MessageFormatUtil;
import lotto.constants.utils.NumberUtil;
import lotto.domain.Lotto;

public class OutputMessageGenerator {
    public static final int WIN_RESULT_COUNT = 5;
    public static final int ZERO_WIN = 0;

    public String createBuyingLottoResultMessage(List<Lotto> buyingLottos) {
        StringBuilder allLottoNumber = new StringBuilder();
        buyingLottos.stream()
                .map(Lotto::createMessage)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(MessageFormatUtil.NEXT_LINE));
        return allLottoNumber.deleteCharAt(allLottoNumber.length() - NumberUtil.ONE)
                .toString();
    }

    public String createBuyingLottoCountMessage(int buyingLottoCount) {
        return String.format(OutputMessage.BOUGHT_FORMAT, buyingLottoCount);
    }

    public String createStatisticsMessage(Map<WinResultStatus, Integer> statisticsCounts) {
        // TODO 리팩토링
        StringBuilder statisticsMessage = new StringBuilder();
        List<WinResultStatus> winResultStatuses = WinResultStatus.getWinResultStatuses();
        for (int winResultIndex = 0; winResultIndex < WIN_RESULT_COUNT; winResultIndex++) {
            statisticsMessage.append(
                            fillMessageFormat(winResultIndex, winResultStatuses.get(winResultIndex), statisticsCounts))
                    .append(MessageFormatUtil.NEXT_LINE);
        }
        return statisticsMessage.deleteCharAt(statisticsMessage.lastIndexOf(MessageFormatUtil.NEXT_LINE))
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

    public String createEarningsRateMessage(final double earningsRate) {
        NumberFormat decimalFormat = new DecimalFormat(MessageFormatUtil.PRICE_FORMAT);
        String format = decimalFormat.format(earningsRate);
        return String.format(OutputMessage.EARNINGS_RATIO_FORMAT, format);
    }
}
