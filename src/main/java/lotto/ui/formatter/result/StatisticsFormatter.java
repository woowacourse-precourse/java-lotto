package lotto.ui.formatter.result;

import java.math.BigDecimal;
import java.util.Arrays;
import lotto.domain.winningresult.WinningType;
import lotto.domain.winningresult.LottoStatistics;
import lotto.ui.formatter.OutputFormatter;

public class StatisticsFormatter implements OutputFormatter<LottoStatistics> {
    private static final String WINNING_RESULT_PREFIX = "당첨 통계";
    private static final String RESULT_START_DIVIDER = "---";
    private static final String LINE_BREAK = "\n";
    private static final String COUNT_DASH = " - ";
    private static final String COUNT_UNIT = "개";

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
                .append(WINNING_RESULT_PREFIX)
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
                .append(COUNT_DASH)
                .append(count)
                .append(COUNT_UNIT)
                .append(LINE_BREAK);
    }

    private void appendRewardRate(StringBuilder winningResultsFormat, LottoStatistics lottoStatistics) {
        winningResultsFormat
                .append("총 수익률은 ")
                .append(rateFormat(lottoStatistics.getRewardRate()))
                .append("%입니다.");
    }

    private static String rateFormat(double rate) {
        return String.format("%,.1f", BigDecimal.valueOf(rate));
    }
}
