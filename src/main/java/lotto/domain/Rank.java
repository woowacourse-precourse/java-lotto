package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIFTH(5_000, 3, false),
    FORTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false),
    NO_LUCK(0, 0, false);

    private final int money;
    private final int matchingCount;
    private final boolean bonusNumber;

    Rank(int money, int matchingCount, boolean bonusNumber) {
        this.money = money;
        this.matchingCount = matchingCount;
        this.bonusNumber = bonusNumber;
    }

    private int defaultCount() {
        return 0;
    }

    public static Rank of(int matchingCount, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount && rank.bonusNumber == bonusNumber)
                .findAny()
                .orElse(NO_LUCK);
    }

    public static Map<Rank, Integer> getRankWithCount() {
        return Stream.of(Rank.values()).collect(Collectors.toMap(Function.identity(), Rank::defaultCount));
    }
}
