package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 "),
    THIRD(5, 1500000, "5개 일치 "),
    FOURTH(4, 50000, "4개 일치 "),
    FIFTH(3, 5000, "3개 일치 "),
    NONE(0, 0, "2개 이하 일치");

    private final int count;
    private final int money;
    private final String message;

    Rank(int count, int money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public static Rank valueOf(int count, boolean isBonus) {
        if (count == 5 && isBonus) {
            return SECOND;
        }
        if (count == 5 && !isBonus) {
            return THIRD;
        }
        for (Rank rank : Rank.values()) {
            if (rank.count == count) {
                return rank;
            }
        }
        return null;
    }
}
