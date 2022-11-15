package lotto.domain;

public enum Rank {
    FIRST(1, 2000000000, "6개 일치 "),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 "),
    THIRD(3, 1500000, "5개 일치 "),
    FOURTH(4, 50000, "4개 일치 "),
    FIFTH(5, 5000, "3개 일치 "),
    NONE(0, 0, "2개 이하 일치");

    private final int money;
    private final String message;

    Rank(int count, int money, String message) {
        this.money = money;
        this.message = message;
    }
}
