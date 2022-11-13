package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Ranking {
    FIRST_PLACE(2_000_000_000, (matchNumbers, bonusNumber) -> matchNumbers == 6),
    SECOND_PLACE(30_000_000, (matchNumbers, bonusNumber) -> matchNumbers == 5 && bonusNumber),
    THIRD_PLACE(1_500_000, (matchNumbers, bonusNumber) -> matchNumbers == 5 && !bonusNumber),
    FOURTH_PLACE(50_000, (matchNumbers, bonusNumber) -> matchNumbers == 4),
    FIFTH_PLACE(5_000, (matchNumbers, bonusNumber) -> matchNumbers == 3),
    NOT_RANKED(0, (matchNumbers, bonusNumber) -> matchNumbers < 6);

    private final int reward;
    private final BiPredicate<Integer, Boolean> rankCondition;

    Ranking(int reward, BiPredicate<Integer, Boolean> rankCondition) {
        this.reward = reward;
        this.rankCondition = rankCondition;
    }

    public static Ranking getRank(int numberOfMatchNumbers, boolean bonusNumberMatch) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.rankCondition.test(numberOfMatchNumbers, bonusNumberMatch))
                .findAny()
                .orElse(NOT_RANKED);
    }

    public int getReward() {
        return reward;
    }
}
