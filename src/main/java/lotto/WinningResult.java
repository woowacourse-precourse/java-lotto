package lotto;

import java.text.DecimalFormat;
import java.util.Optional;

public enum WinningResult {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000);


    private final int hitCount;

    private final int reward;

    private boolean hitBonus;

    private DecimalFormat decFormat = new DecimalFormat("###,###");

    WinningResult(int hitCount, int reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    WinningResult(int hitCount, int reward, boolean hitBonus) {
        this.hitCount = hitCount;
        this.reward = reward;
        this.hitBonus = hitBonus;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getHitBonus() {
        return hitBonus;
    }

    @Override
    public String toString() {
        if (this == SECOND) return hitCount+"개 일치, 보너스 볼 일치 ("+decFormat.format(reward)+"원)";
        return hitCount+"개 일치 ("+decFormat.format(reward)+"원)";
    }

    public static Optional<WinningResult> valueOf(int hitCount, boolean hitBonus) {
        Optional<WinningResult> winningResult = Optional.empty();
        for (WinningResult result : WinningResult.values()) {
            if (result.hitCount == hitCount) {
                winningResult = Optional.of(result);
                break;
            }
        }
        if (winningResult.isPresent() && winningResult.get() == THIRD && hitBonus) {
            winningResult = Optional.of(SECOND);
        }
        return winningResult;
    }
}
