package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.result.WinningRank;
import lotto.model.result.WinningStatistics;

public class ResultFormatter {

    private enum ResultMessage {
        TOTAL_REWARD_RATE("총 수익률은 %s%%입니다."),
        WINNING_STATISTICS("%s (%s원) - %d개\n");

        private final String message;

        ResultMessage(String message) {
            this.message = message;
        }
    }

    private enum Regex {
        CASH_PRIZE_REGEX("\\B(?=(\\d{3})+(?!\\d))"),
        DECIMAL_FORMAT("#,##0.0");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    public static List<WinningRank> formatRanksInOrder() {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String formatResult(WinningStatistics winningStatistics) {
        StringBuilder result = new StringBuilder();
        addStatistics(winningStatistics, result);
        addRewardRate(winningStatistics, result);
        return result.toString();
    }

    private static void addRewardRate(WinningStatistics winningStatistics, StringBuilder result) {
        result.append(String.format(ResultMessage.TOTAL_REWARD_RATE.message, winningStatistics.getRewardRate()));
    }

    private static void addStatistics(WinningStatistics winningStatistics, StringBuilder result) {
        List<WinningRank> ranks = formatRanksInOrder();
        for (WinningRank rank : ranks) {
            result.append(
                    String.format(ResultMessage.WINNING_STATISTICS.message,
                            rank.getDisplay(),
                            formatCashPrize(rank.getCashPrize()),
                            winningStatistics.getWinningStatistics(rank)));
        }
    }

    private static String formatCashPrize(int cashPrize) {
        return String.valueOf(cashPrize).replaceAll(Regex.CASH_PRIZE_REGEX.regex, ",");
    }

    public static String formatRewardRate(BigDecimal rewardRate) {
        return new DecimalFormat(Regex.DECIMAL_FORMAT.regex).format(rewardRate);
    }
}
