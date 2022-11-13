package lotto.ui.formatter.result;

import java.math.BigDecimal;
import java.util.Arrays;
import lotto.domain.winningresult.WinningResultType;
import lotto.domain.winningresult.WinningResults;
import lotto.ui.formatter.OutputFormatter;

public class WinningResultsFormatter implements OutputFormatter<WinningResults> {
    private static final String WINNING_RESULT_PREFIX = "당첨 통계";
    private static final String RESULT_START_DIVIDER = "---";
    private static final String LINE_BREAK = "\n";
    private static final String COUNT_DASH = " - ";
    private static final String COUNT_UNIT = "개";
    private final OutputFormatter<WinningResultType> winningResultTypeFormatter;

    public WinningResultsFormatter(OutputFormatter<WinningResultType> winningResultTypeFormatter) {
        this.winningResultTypeFormatter = winningResultTypeFormatter;
    }

    @Override
    public String outputFormat(WinningResults winningResults) {
        StringBuilder winningResultsFormat = new StringBuilder();

        appendResultPrefix(winningResultsFormat);
        appendResultAmount(winningResultsFormat, winningResults);
        appendRewardRate(winningResultsFormat, winningResults);

        return winningResultsFormat.toString();
    }

    private void appendResultPrefix(StringBuilder winningResultsFormat) {
        winningResultsFormat
                .append(WINNING_RESULT_PREFIX)
                .append(LINE_BREAK)
                .append(RESULT_START_DIVIDER)
                .append(LINE_BREAK);
    }

    private void appendResultAmount(StringBuilder winningResultsFormat, WinningResults winningResults) {
        Arrays.stream(WinningResultType.values())
                .forEach(o -> {
                    int count = winningResults.count(o);
                    winningResultsFormat.append(getSingleResultFormatWithCount(count, o));
                });
    }

    private StringBuilder getSingleResultFormatWithCount(int count, WinningResultType o) {
        return new StringBuilder(winningResultTypeFormatter.outputFormat(o))
                .append(COUNT_DASH)
                .append(count)
                .append(COUNT_UNIT)
                .append(LINE_BREAK);
    }

    private void appendRewardRate(StringBuilder winningResultsFormat, WinningResults winningResults) {
        winningResultsFormat
                .append("총 수익률은 ")
                .append(rateFormat(winningResults.calculateRewardRate()))
                .append("%")
                .append("입니다.");
    }

    private static String rateFormat(double rate) {
        return String.format("%.1f", BigDecimal.valueOf(rate));
    }
}
