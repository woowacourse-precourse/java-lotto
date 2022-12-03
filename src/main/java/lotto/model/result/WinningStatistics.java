package lotto.model.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final PlayerNumbers playerNumbers;
    private Map<WinningRank, Integer> winningStatistics = new HashMap<>();
    public static final String CASH_PRIZE_REGEX = "\\B(?=(\\d{3})+(?!\\d))";

    private WinningStatistics(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        this.lottoDraw = lottoDraw;
        this.playerNumbers = playerNumbers;
        initializeStatistics();
        drawWinningStatistics();
        System.out.println(winningStatistics);
    }

    public static WinningStatistics from(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        return new WinningStatistics(lottoDraw, playerNumbers);
    }

    private void drawWinningStatistics() {
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(player), hasBonus(player));
            winningStatistics.put(winningRank, winningStatistics.get(winningRank) + 1);
        }
    }

    private void initializeStatistics() {
        for (WinningRank winningRank : WinningRank.values()) {
            winningStatistics.put(winningRank, 0);
        }
    }


    private boolean hasBonus(PlayerNumber player) {
        return player.getPlayerNumber().contains(lottoDraw.getBonusNumber());
    }

    private int calculateMatch(PlayerNumber player) {
        List<Integer> intersection = new ArrayList<>(player.getPlayerNumber());
        intersection.retainAll(lottoDraw.getWinningNumbers());
        return intersection.size();
    }

    @Override
    public String toString() {
        List<WinningRank> ranks = Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (WinningRank rank : ranks) {
            result.append(
                    String.format("%s (%s원) - %d개\n",
                            rank.getDisplay(),
                            formatCashPrize(rank.getCashPrize()),
                            winningStatistics.get(rank)));
        }
        return result.toString();
    }


    public static String formatCashPrize(int cashPrize) {
        return String.valueOf(cashPrize).replaceAll(CASH_PRIZE_REGEX, ",");
    }
}
