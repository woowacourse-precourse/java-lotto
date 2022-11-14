package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {
    NONE(0, 0, (matchCount, matchBonus) -> matchCount < 3),
    FIFTH(5000, 3, (matchCount, matchBonus) -> matchCount == 3),
    FOURTH(50000, 4, (matchCount, matchBonus) -> matchCount == 4),
    THIRD(1500000, 5, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    SECOND(30000000, 5, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    FIRST(2000000000, 6, (matchCount, matchBonus) -> matchCount == 6);

    private final int price;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isMatch;


    Rank(int price, int matchCount, BiPredicate<Integer, Boolean> isMatch) {
        this.price = price;
        this.matchCount = matchCount;
        this.isMatch = isMatch;
    }

    public static Rank valueOf(int matchCount, boolean bonus) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.isMatch.test(matchCount, bonus))
            .findAny()
            .orElse(NONE);
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
