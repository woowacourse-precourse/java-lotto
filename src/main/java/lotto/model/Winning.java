package lotto.model;

import java.util.Arrays;

public enum Winning {
    DEFAULT(0, 0, false, "상금 없음"),
    FIFTH(3, 5_000, false, "3개 일치"),
    FOURTH(4, 50_000, false, "4개 일치"),
    THIRD(5, 1_500_000, false, "5개 일치"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, false, "6개 일치");

    private final int sameCount;
    private final int prize;
    private final boolean bonus;
    private final String detail;

    Winning(int sameCount, int prize, boolean bonus, String detail) {
        this.sameCount = sameCount;
        this.prize = prize;
        this.bonus = bonus;
        this.detail = detail;
    }

    public int getPrize() {
        return prize;
    }

    public String getDetail() {
        return detail;
    }

    public static Winning findWinning(int count, boolean bonus) {
        return Arrays.stream(Winning.values())
                .filter(winning -> (winning.sameCount == count) && (winning.bonus == bonus))
                .findAny()
                .orElse(DEFAULT);
    }
}
