package lotto.model.result;

import static lotto.util.Constants.LOTTO_PRICE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;
import net.bytebuddy.pool.TypePool.Resolution.NoSuchTypeException;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final PlayerNumbers playerNumbers;
    private Map<WinningRank, Integer> winningStatistics = new HashMap<>();
    private BigDecimal rewardRate = BigDecimal.ZERO;
    public static final String CASH_PRIZE_REGEX = "\\B(?=(\\d{3})+(?!\\d))";

    private WinningStatistics(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        this.lottoDraw = lottoDraw;
        this.playerNumbers = playerNumbers;
        setStatistics();
    }

    public static WinningStatistics from(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        return new WinningStatistics(lottoDraw, playerNumbers);
    }

    private void setStatistics() {
        BigDecimal ticketBudget = new BigDecimal("0");
        BigDecimal totalCashPrize = new BigDecimal("0");
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(player), hasBonus(player));
            winningStatistics.put(winningRank, winningStatistics.getOrDefault(winningRank, 0) + 1);
            ticketBudget = ticketBudget.add(new BigDecimal(String.valueOf(LOTTO_PRICE)));
            totalCashPrize = totalCashPrize.add(new BigDecimal(String.valueOf(winningRank.getCashPrize())));
        }
        rewardRate = totalCashPrize.divide(ticketBudget).multiply(BigDecimal.valueOf(100));
        System.out.println(rewardRate);
    }

    private boolean hasBonus(PlayerNumber player) {
        return player.getPlayerNumber().contains(lottoDraw.getBonusNumber());
    }

    private int calculateMatch(PlayerNumber player) {
        List<Integer> intersection = new ArrayList<>(player.getPlayerNumber());
        intersection.retainAll(lottoDraw.getWinningNumbers());
        return intersection.size();
    }

    private String getRewardRate() {
        return String.valueOf(formatRewardRate());
    }

    private BigDecimal formatRewardRate() {
        return rewardRate.setScale(1, RoundingMode.HALF_EVEN);
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
                            winningStatistics.getOrDefault(rank, 0)));
        }
        result.append(String.format("총 수익률은 %s%%입니다.", getRewardRate()));
        return result.toString();
    }


    public static String formatCashPrize(int cashPrize) {
        return String.valueOf(cashPrize).replaceAll(CASH_PRIZE_REGEX, ",");
    }
}
