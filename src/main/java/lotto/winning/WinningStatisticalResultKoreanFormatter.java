package lotto.winning;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.function.Predicate;

public class WinningStatisticalResultKoreanFormatter implements WinningStatisticalFormatter {
    @Override
    public String format(WinningStatistical winningStatistical) {
        return getHeader() + getBody(winningStatistical) + getFooter(winningStatistical);
    }

    private String getHeader() {
        return "당첨 통계\n" + "---\n";
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
            bonusMatchedMessage.insert(0, ", 보너스 볼 일치");
        }
        return String.format("%d개 일치%s(%s원) - %d개\n", winningResult.getMatchedCount(), bonusMatchedMessage,
                NumberFormat.getInstance().format(winningResult.getPrize()),
                winningStatistical.getCountOfWinningResult(winningResult));
    }

    private String getFooter(WinningStatistical winningStatistical) {
        return String.format("총 수익률은 %.1f%%입니다.", winningStatistical.calculateProfit());
    }
}
