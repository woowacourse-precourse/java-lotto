package lotto.userinterface;

public enum Hit {
    THREE(5_000),
    FOUR(50_000),
    FIVE(15_000_000),
    FIVE_BONUS(30_000_000),
    SIZE(2_000_000_000);

    private Integer prize;

    Hit(Integer prize) {
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }
}
