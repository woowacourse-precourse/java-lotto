package lotto;

public enum Prize {
    FIRST(6, "2,000,000,000원", 2000000000L),
    SECOND(5, "30,000,000원", 30000000L),
    THIRD(5, "1,500,000원", 1500000L),
    FOURTH(4, "50,000원", 50000L),
    FIFTH(3, "5,000원", 5000L),
    NONE(0, "0", 0L);

    public final int matches;
    public final String price;
    public final long money;

    Prize(int matches, String price, long money) {
        this.matches = matches;
        this.price = price;
        this.money = money;
    }

    public static String prizeInfo(Prize prize) {
        if (prize == SECOND) {
            return prize.matches + "개 일치, 보너스 볼 일치 " + "(" + prize.price + ")";
        }
        return prize.matches + "개 일치 " + "(" + prize.price + ")";
    }
}
