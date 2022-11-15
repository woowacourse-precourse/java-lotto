package lotto.winning;

import java.util.Arrays;
import java.util.Optional;

public enum WinningResult {
    NOTHING(0, false, 0),
    FIFTH_PRIZE(3, false, 5_000),
    FORTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000);

    private final Integer matchedCount;
    private final Boolean bonusMatched;

    private final Integer prize;

    WinningResult(Integer matchedCount, Boolean bonusMatched, Integer prize) {
        this.matchedCount = matchedCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
    }

    public static WinningResult generate(Integer matchedCount, Boolean bonusMatched) {
        Optional<WinningResult> optWinningResult = Arrays.stream(WinningResult.values()).filter(winningResult ->
                winningResult.getMatchedCount().equals(matchedCount) && (winningResult.getBonusMatched()
                        && !bonusMatched)).findAny();
        return optWinningResult.orElse(NOTHING);
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public Boolean getBonusMatched() {
        return bonusMatched;
    }

    public Integer getPrize() {
        return prize;
    }
}
