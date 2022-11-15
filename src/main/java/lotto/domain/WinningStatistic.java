package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningStatistic {

    public static final long SIX_WINNING_PRICE = 2_000_000_000L;
    public static final long FIVE_BONUS_WINNING_PRICE = 30_000_000L;
    public static final long FIVE_WINNING_PRICE = 1_500_000L;
    public static final long FOUR_WINNING_PRICE = 50_000L;
    public static final long THREE_WINNING_PRICE = 5_000L;

    public WinningStatistic() {
    }

    public List<Integer> calcWinningResult(LottoPile lottoPile, List<Integer> winningNumber, Integer bonusNumber) {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0, 0, 0);

        List<Lotto> lottos = lottoPile.getLottos();

        for (Lotto lotto : lottos) {
            countResult(winningNumber, bonusNumber, result, lotto);
        }

        return result;
    }

    public double calcRevenue(List<Integer> winningResult, int amount) {
        long WinningAmount = calcWinningAmount(winningResult);

        double revenue = (double)WinningAmount / (double)amount;

        return Math.round(revenue * 1000)/10.0;
    }
    private Long calcWinningAmount(List<Integer> winningResult) {
        long total = 0;

        total += winningResult.get(6) * SIX_WINNING_PRICE;
        total += winningResult.get(0) * FIVE_BONUS_WINNING_PRICE;
        total += winningResult.get(5) * FIVE_WINNING_PRICE;
        total += winningResult.get(4) * FOUR_WINNING_PRICE;
        total += winningResult.get(3) * THREE_WINNING_PRICE;

        return total;
    }

    private void countResult(List<Integer> winningNumber, Integer bonusNumber, List<Integer> result, Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;

        List<Integer> numbers = lotto.getNumbers();

        for (int number : numbers) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
            if (bonusNumber.equals(number)) {
                matchBonus = true;
            }
        }
        addEachResult(result, matchCount, matchBonus);
    }

    private void addEachResult(List<Integer> result, int matchCount, boolean matchBonus) {
        addSixResult(result, matchCount);

        addFiveAndBonusResult(result, matchCount, matchBonus);

        addFiveResult(result, matchCount);

        addFourResult(result, matchCount);

        addThreeResult(result, matchCount);
    }

    private void addThreeResult(List<Integer> result, int matchCount) {
        if (matchCount == WinningResult.MATCH_THREE.getValue()) {
            int tmp = result.get(3);
            result.set(3, tmp + 1);
        }
    }

    private void addFourResult(List<Integer> result, int matchCount) {
        if (matchCount == WinningResult.MATCH_FOUR.getValue()) {
            int tmp = result.get(4);
            result.set(4, tmp + 1);
        }
    }

    private void addFiveResult(List<Integer> result, int matchCount) {
        if (matchCount == WinningResult.MATCH_FIVE.getValue()) {
            int tmp = result.get(5);
            result.set(5, tmp + 1);
        }
    }

    private void addFiveAndBonusResult(List<Integer> result, int matchCount, boolean matchBonus) {
        if (matchCount == WinningResult.MATCH_FIVE.getValue() && matchBonus) {
            int tmp = result.get(0);
            result.set(0, tmp + 1);
        }
    }

    private void addSixResult(List<Integer> result, int matchCount) {
        if (matchCount == WinningResult.MATCH_SIX.getValue()) {
            int tmp = result.get(6);
            result.set(6, tmp + 1);
        }
    }
}
