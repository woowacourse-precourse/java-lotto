package lotto.domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class WinningHistory {
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;
    private int winningAmount;
    private final double yield;

    public WinningHistory(ArrayList<Map<String, Object>> results) {
        analysis(results);
        double yield = (double) winningAmount / (1_000 * results.size()) * 100;
        this.yield = (double) Math.round(yield * 10) / 10;
    }

    private void analysis(ArrayList<Map<String, Object>> results) {
        for (Map<String, Object> result : results) {
            WinningRule winningRule = checkWinning(result);
            if (winningRule == WinningRule.FIRST) {
                firstCount++;
            }
            if (winningRule == WinningRule.SECOND) {
                secondCount++;
            }
            if (winningRule == WinningRule.THIRD) {
                thirdCount++;
            }
            if (winningRule == WinningRule.FOURTH) {
                fourthCount++;
            }
            if (winningRule == WinningRule.FIFTH) {
                fifthCount++;
            }
            winningAmount += winningRule.winningAmount();
        }
    }

    private WinningRule checkWinning(Map<String, Object> result) {
        Optional<WinningRule> checkResult = WinningRule.check(result);
        return checkResult.orElse(WinningRule.NOT_WINNER);
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public double getYield() {
        return yield;
    }
}
