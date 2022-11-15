package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private Integer countOfMatch;
    private Integer winningMoney;

    private Rank(Integer countOfMatch, Integer winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank findByCountOfMatchAndMatchBonus(Integer countOfMatch, Boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank ->
                        rank.equals(countOfMatch, matchBonus)
                )
                .findAny()
                .orElse(Rank.MISS);
    }

    private boolean equals(Integer countOfMatch, Boolean matchBonus) {
        if (isRankNameSecondButNotMatchBonus(matchBonus)) {
            return false;
        }

        return this.countOfMatch.equals(countOfMatch);
    }

    private boolean isRankNameSecondButNotMatchBonus(Boolean matchBonus) {
        return isSecond() && !equalsMatchBonus(matchBonus);
    }

    private boolean isSecond() {
        return this.name().equals(Rank.SECOND.name());
    }

    private boolean equalsMatchBonus(Boolean matchBonus) {
        return matchBonus != null && matchBonus.equals(true);
    }
}
