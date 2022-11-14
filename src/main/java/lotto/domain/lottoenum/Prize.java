package lotto.domain.lottoenum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int money;
    private final boolean hasBonus;

    Prize(int matchCount, int money, boolean hasBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.hasBonus = hasBonus;
    }

    public static Prize checkPrizeToReceive(long matchCount, boolean hasBonus) {
        List<Prize> prizes = Stream.of(values())
                .filter(prize -> isMatchCountSame(matchCount, prize.matchCount))
                .collect(Collectors.toList());

        return getOnlyOneWithBonusMatch(prizes, hasBonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    private static Prize getOnlyOneWithBonusMatch(List<Prize> prizes, boolean hasBonus) {
        if (prizes.size() <= 1) {
            return prizes.stream().findFirst().orElse(NONE);
        }
        return getPrizeConsideringBonus(prizes, hasBonus);
    }

    private static boolean isMatchCountSame(long matchCount, int prizeCount) {
        return matchCount == prizeCount;
    }

    private static boolean isBonusIncluded(boolean inputBonus, boolean prizeBonus) {
        return inputBonus == prizeBonus;
    }

    private static Prize getPrizeConsideringBonus(List<Prize> prizes, boolean inputBonus) {
        return prizes.stream()
                .filter(prize -> isBonusIncluded(inputBonus, prize.hasBonus))
                .findAny()
                .orElse(NONE);
    }

}
