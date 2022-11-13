package lotto.domain;

import java.util.Optional;

public enum Winning {

    FIRST(6, 0, 2_000_000_000L),
    SECOND(5, 1, 30_000_000L),
    THIRD(5, 0, 1_500_000L),
    FOURTH(4, 0, 50_000L),
    FIFTH(  3, 0, 5_000L);

    private final int sameCount;
    private final int bonusCount;
    private final Long winnings;

    Winning(int sameCount, int bonusCount, Long winnings) {
        this.sameCount = sameCount;
        this.bonusCount = bonusCount;
        this.winnings = winnings;
    }

    public static Optional<Winning> getWinning(int sameCount, int bonusCount) {
        for (Winning current : Winning.values()) {
            if (current.sameCount == sameCount && current.bonusCount == bonusCount) {
                return Optional.of(current);
            }
        }

        return Optional.empty();
    }

    public Long getWinnings() {
        return this.winnings;
    }

}
