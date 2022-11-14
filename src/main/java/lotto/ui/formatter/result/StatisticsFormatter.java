package lotto.ui.formatter.result;

import java.math.BigDecimal;
import java.util.Arrays;
import lotto.domain.winningresult.WinningType;
import lotto.domain.winningresult.LottoStatistics;
import lotto.ui.formatter.OutputFormatter;

public class StatisticsFormatter implements OutputFormatter<LottoStatistics> {
    private static final String RESULT_PREFIX = "당첨 통계";
    private static final String RESULT_START_DIVIDER = "---";
    private static final String LINE_BREAK = "\n";
    private static final String RESULT_COUNT_FORMAT = " - %d개";
    private static final String EARN_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.";

    private final OutputFormatter<WinningType> winningTypeFormatter;

    public StatisticsFormatter(OutputFormatter<WinningType> winningTypeFormatter) {
        this.winningTypeFormatter = winningTypeFormatter;
    }

    @Override
    public String outputFormat(LottoStatistics lottoStatistics) {
        StringBuilder format = new StringBuilder();

        appendStatisticsPrefix(format);
        appendWinningTypes(format, lottoStatistics);
        appendRewardRate(format, lottoStatistics);

        return format.toString();
    }

    private void appendStatisticsPrefix(StringBuilder winningResultsFormat) {
        winningResultsFormat
                .append(RESULT_PREFIX)
                .append(LINE_BREAK)
                .append(RESULT_START_DIVIDER)
                .append(LINE_BREAK);
    }

    private void appendWinningTypes(StringBuilder winningResultsFormat, LottoStatistics lottoStatistics) {
        Arrays.stream(WinningType.values())
                .forEach(o -> {
                    int count = lottoStatistics.count(o);
                    winningResultsFormat.append(getSingleResultFormatWithCount(count, o));
                });
    }

    private StringBuilder getSingleResultFormatWithCount(int count, WinningType o) {
        return new StringBuilder(winningTypeFormatter.outputFormat(o))
                .append(String.format(RESULT_COUNT_FORMAT, count))
                .append(LINE_BREAK);
    }

    private void appendRewardRate(StringBuilder winningResultsFormat, LottoStatistics lottoStatistics) {
        double rate = lottoStatistics.getRewardRate();
        winningResultsFormat
                .append(String.format(EARN_RATE_FORMAT, BigDecimal.valueOf(rate)));
    }
}
