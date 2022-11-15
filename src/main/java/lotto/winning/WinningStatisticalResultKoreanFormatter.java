package lotto.winning;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.function.Predicate;

public class WinningStatisticalResultKoreanFormatter implements WinningStatisticalFormatter {
    public static final String HEADER = "당첨 통계\n---\n";
    public static final String BONUS_BALL_SAME = ", 보너스 볼 일치";
    public static final String WINNING_RESULT_FORMATTER = "%d개 일치%s(%s원) - %d개\n";
    public static final String PROFIT_FORMATTER = "총 수익률은 %.1f%%입니다.";

    @Override
    public String format(WinningStatistical winningStatistical) {
        return getHeader() + getBody(winningStatistical) + getFooter(winningStatistical);
    }

    private String getHeader() {
        return HEADER;
    }

    private String getBody(WinningStatistical winningStatistical) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(WinningResult.values()).filter(Predicate.not(WinningResult.NOTHING::equals))
                .forEach(winningResult -> stringBuilder.append(formatWinningResult(winningStatistical, winningResult)));
        return stringBuilder.toString();
    }

    private String formatWinningResult(WinningStatistical winningStatistical, WinningResult winningResult) {
        StringBuilder bonusMatchedMessage = new StringBuilder(" ");
        if (winningResult.getBonusMatched()) {
            bonusMatchedMessage.insert(0, BONUS_BALL_SAME);
        }
        return String.format(WINNING_RESULT_FORMATTER, winningResult.getMatchedCount(), bonusMatchedMessage,
                NumberFormat.getInstance().format(winningResult.getPrize()),
                winningStatistical.getCountOfWinningResult(winningResult));
    }

    private String getFooter(WinningStatistical winningStatistical) {
        return String.format(PROFIT_FORMATTER, winningStatistical.calculateProfit());
    }
}
