package lotto;

import java.util.Arrays;

public enum LottoPrize {
    MISS(0, 0, new Money(0)),
    FIFTH(3, 0, new Money(5000)),
    FOURTH(4, 0, new Money(50000)),
    THIRD(5, 0, new Money(1500000)),
    SECOUND(5, 1, new Money(30000000)),
    FIRST(3, 0, new Money(2000000000));

    private final int numberMatch;
    private final int bonusNumberMatch;
    private final Money reward;

    LottoPrize(int numberMatch, int bonusNumberMatch, Money reward) {
        this.numberMatch = numberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.reward = reward;
    }

    public static LottoPrize match(int numberMatch, int bonusNumberMatch) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> checkMatch(prize, numberMatch, bonusNumberMatch))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean checkMatch(LottoPrize prize, int numberMatch, int bonusNumberMatch) {
        if (prize.equals(LottoPrize.SECOUND)) {
            return numberMatch == prize.numberMatch && bonusNumberMatch == prize.bonusNumberMatch;
        }
        if (prize.equals(LottoPrize.THIRD)) {
            return numberMatch == prize.numberMatch && bonusNumberMatch == prize.bonusNumberMatch;
        }
        return prize.numberMatch == numberMatch;
    }

    public int getLottoNumberMatches() {
        return numberMatch;
    }

    public Money getReward() {
        return reward;
    }

    public int getTotalReward(int number) {
        return reward.get() * number;
    }

}
