package lotto.resources;

public enum Rank {

    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    BONUS(7, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final Integer rank;
    private final Long money;

    Rank(Integer rank, Long money) {
        this.rank = rank;
        this.money = money;
    }

    public static Long getMoney(int index) {
        for (Rank rank : Rank.values()) {
            if (rank.rank == index) {
                return rank.money;
            }
        }
        return 0L;
    }

    public Integer getRank() {
        return this.rank;
    }

    public Long getMoney() {
        return this.money;
    }
}
