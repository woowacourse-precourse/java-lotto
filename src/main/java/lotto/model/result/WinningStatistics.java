package lotto.model.result;

import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.ResultFormatter.formatResult;
import static lotto.util.ResultFormatter.formatRewardRate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;
import lotto.util.ResultFormatter;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final PlayerNumbers playerNumbers;
    private Map<WinningRank, Integer> winningStatistics = new EnumMap<>(WinningRank.class);
    private BigDecimal rewardRate = BigDecimal.ZERO;

    private WinningStatistics(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        this.lottoDraw = lottoDraw;
        this.playerNumbers = playerNumbers;
        setWinningStatistics();
        setRewardRate();
    }

    public static WinningStatistics from(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        return new WinningStatistics(lottoDraw, playerNumbers);
    }

    private void setWinningStatistics() {
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(player), hasBonus(player));
            updateWinningStatistics(winningRank);
        }
    }

    private void setRewardRate() {
        BigDecimal ticketBudget = BigDecimal.ZERO;
        BigDecimal totalCashPrize = BigDecimal.ZERO;
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(player), hasBonus(player));
            ticketBudget = ticketBudget.add(new BigDecimal(String.valueOf(LOTTO_PRICE)));
            totalCashPrize = totalCashPrize.add(new BigDecimal(String.valueOf(winningRank.getCashPrize())));
        }
        rewardRate = calculateRewardRate(ticketBudget, totalCashPrize);
    }

    private static BigDecimal calculateRewardRate(BigDecimal ticketBudget, BigDecimal totalCashPrize) {
        if (totalCashPrize.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return totalCashPrize.divide(ticketBudget).multiply(BigDecimal.valueOf(100));
    }

    private void updateWinningStatistics(WinningRank winningRank) {
        winningStatistics.put(winningRank, winningStatistics.getOrDefault(winningRank, 0) + 1);
    }

    public int getWinningStatistics(WinningRank winningRank) {
        return winningStatistics.getOrDefault(winningRank, 0);
    }

    private boolean hasBonus(PlayerNumber player) {
        return player.getPlayerNumber().contains(lottoDraw.getBonusNumber());
    }

    private int calculateMatch(PlayerNumber player) {
        List<Integer> intersection = new ArrayList<>(player.getPlayerNumber());
        intersection.retainAll(lottoDraw.getWinningNumbers());
        return intersection.size();
    }

    public String getRewardRate() {
        return ResultFormatter.formatRewardRate(rewardRate);
    }


    @Override
    public String toString() {
        return formatResult(this);
    }


}
