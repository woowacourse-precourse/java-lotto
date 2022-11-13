package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    ZERO(-1, 0, "NONE"),
    THREE(3, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, 50_000, "4개 일치 (50,000원) - "),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIVE_ALPHA(6, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(7, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");


    private int count;
    private int money;
    private String message;


    Rank(int count, int money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public int getMoney(int count) {
        return money * count;
    }

    public String getMessage(int count) {
        return message + count + "개";
    }

    public static Rank findMoney(int count) {
        return Stream.of(values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(ZERO);
    }
}
