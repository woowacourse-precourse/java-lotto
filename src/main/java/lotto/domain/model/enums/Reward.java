package lotto.domain.model.enums;

import java.util.Arrays;
import java.util.Optional;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public enum Reward {

    FIRST(6, 2000000000L, false),
    SECOND(5, 30000000L, true),
    THIRD(5, 1500000L, false),
    FOURTH(4, 50000L, false),
    FIFTH(3, 5000L, false),
    ELSE(0, 0, false);

    private final int correctCount;
    private final long price;
    private final boolean hasBonusNumber;

    Reward(int correctCount, long price, boolean hasBonusNumber) {
        this.correctCount = correctCount;
        this.price = price;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getPrice() {
        return price;
    }

    public static Reward getRank(WinningLotto winningLotto, Lotto lotto) {
        int targetCount = winningLotto.getLotto()
                .getCorrectCount(lotto);
        boolean isContain = lotto.contains(winningLotto.getBonusNumber());

        Optional<Reward> reward = Arrays.stream(Reward.values())
                .filter(r -> r.hasBonusNumber == isContain && r.correctCount == targetCount)
                .findFirst();
        return reward.orElse(ELSE);
    }


}
