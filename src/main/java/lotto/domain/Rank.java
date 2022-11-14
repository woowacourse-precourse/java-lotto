package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    EMPTY(0, 0, false, "0개 일치 - "),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");

    public static final int BONUS_CONTAIN_CONDITION = 5;

    private final int prize;
    private final int matchCount;
    private final boolean bonus;
    private final String message;


    Rank(final int prize, final int matchCount, final boolean bonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.message = message;
    }

    public static Rank calculate(Lotto lotto, WinningNumber winningNumber) {
        final int matchCount = getMatchCount(lotto, winningNumber.getLotto().getNumbers());

        boolean bonus = false;
        if (matchCount == BONUS_CONTAIN_CONDITION) {
            bonus = lotto.hasMatchedNumber(winningNumber.getBonusNumber());
        }

        return getRank(matchCount, bonus);
    }

    private static int getMatchCount(Lotto lotto, List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(lotto::hasMatchedNumber)
                .count();
    }

    private static Rank getRank(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(EMPTY);
    }

    public static List<Rank> getValidRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.EMPTY)
                .collect(Collectors.toList());
    }

    public static long calculateEarning(List<Rank> results) {
        return results.stream()
                .mapToLong(rank -> rank.getPrize())
                .sum();
    }

    public long calculateCount(List<Rank> results) {
        return results.stream()
                .filter(rank -> rank.matchCount == this.getMatchCount())
                .count();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }
}
