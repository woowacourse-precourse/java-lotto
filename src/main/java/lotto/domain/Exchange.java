package lotto.domain;

public enum Exchange {
    NOTHING(0, false, 0, "낙첨입니다."),
    FIVE(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, false, 50_000, "4개 일치 (50,000원) - "),
    THREE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    TWO(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ONE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");
    private final int match;
    private final boolean bonus;
    private final long price;
    private final String message;

    Exchange(int match, boolean bonus, long price, String message) {
        this.match = match;
        this.bonus = bonus;
        this.price = price;
        this.message = message;
    }

    public boolean isMatch(Integer match) {
        return this.match == match;
    }

    public boolean isBonus(boolean bonus) {
        return this.bonus == bonus;
    }

    public long getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
