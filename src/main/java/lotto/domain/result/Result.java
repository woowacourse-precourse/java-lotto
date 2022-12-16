package lotto.domain.result;

import lotto.domain.reward.Reward;

import java.util.Optional;

public class Result {
    private int matchedCount;
    private boolean isMatchedBonus;

    public Result(long matchedCount, boolean isMatchedBonus) {
        this.matchedCount = (int) matchedCount;
        this.isMatchedBonus = isMatchedBonus;
    }

    public Optional<Reward> matchReward() {
        if (matchedCount < 3) {
            return Optional.empty();
        } else if (matchedCount == 3) {
            return Optional.of(Reward.FIFTH);
        } else if (matchedCount == 4) {
            return Optional.of(Reward.FOURTH);
        } else if (matchedCount == 5) {
            if (isMatchedBonus) {
                return Optional.of(Reward.SECOND);
            }
            return Optional.of(Reward.THIRD);
        }
        return Optional.of(Reward.FIRST);}

}
