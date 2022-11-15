package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningStatisticsCalculator {
    private final HashMap<WinningHistory, Integer> winningHistory;
    private double totalPrizeMoney;

    public WinningStatisticsCalculator() {
        this.winningHistory = new HashMap<>() {{
            put(WinningHistory.FIRST_PRIZE, 0);
            put(WinningHistory.SECOND_PRIZE, 0);
            put(WinningHistory.THIRD_PRIZE, 0);
            put(WinningHistory.FOURTH_PRIZE, 0);
            put(WinningHistory.FIFTH_PRIZE, 0);
            put(WinningHistory.BLANK, 0);
        }};

        totalPrizeMoney = 0;
    }

    public HashMap<WinningHistory, Integer> getWinningHistory() {
        return winningHistory;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            increaseWinningHistoryType(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void increaseWinningHistoryType(int matchNumber, boolean matchBonus) {
        WinningHistory prizeType = WinningHistory.getWinningHistoryType(matchNumber, matchBonus);
        winningHistory.put(prizeType, winningHistory.get(prizeType) + 1);
        plusTotalPrizeMoney(prizeType.getPrizeMoney());
    }

    private void plusTotalPrizeMoney(int prizeMoney) {
        totalPrizeMoney += prizeMoney;
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String calculateRateOfReturn(int amount) {
        totalPrizeMoney *= 1.0;
        return roundTowDecimalPlaces((totalPrizeMoney / amount) * 100);
    }

    private String roundTowDecimalPlaces(double rate) {
        return String.format("%.1f", rate);
    }
}
