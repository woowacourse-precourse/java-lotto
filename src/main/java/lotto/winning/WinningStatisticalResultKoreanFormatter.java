package lotto.winning;

import java.util.Arrays;

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
        Arrays.stream(WinningResult.values())
                .forEach(winningResult -> stringBuilder.append(formatWinningResult(winningStatistical, winningResult)));
        return stringBuilder.toString();
    }

    private String formatWinningResult(WinningStatistical winningStatistical, WinningResult winningResult) {
        return String.format("%d개 일치 (%s원) - %d개\n", winningResult.getMatchedCount(), winningResult.getPrize(),
                winningStatistical.getCountOfWinningResult(winningResult));
    }

    private String getFooter(WinningStatistical winningStatistical) {
        return String.format("총 수익률은 %f%%입니다.", winningStatistical.calculateProfit());
    }
}
