package lotto.domain;

public enum Winning {

    FIRST(6, 2_000_000_000, "6개 일치", false),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치", true),
    THIRD(5, 1_500_000, "5개 일치", false),
    FOURTH(4, 50_000, "4개 일치", false),
    FIFTH(3, 5000, "3개 일치", false);

    private final int match;
    private final long price;
    private final String msg;
    private final boolean bonus;

    Winning(int match, long price, String msg, boolean bonus) {
        this.match = match;
        this.price = price;
        this.msg = msg;
        this.bonus = bonus;
    }

    public String getMsg() { return msg; }
    public int getMatch() { return match; }
    public boolean isBonus() { return bonus; }
    public long getPrice() { return price;}
}