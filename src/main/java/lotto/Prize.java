package lotto;

public enum Prize {
    FIRST(6, "2,000,000,000원"),
    SECOND(5, "30,000,000원"),
    THIRD(5, "1,500,000원"),
    FOURTH(4, "50,000원"),
    FIFTH(3, "5,000"),
    NONE(0, "0");

    final int matches;
    final String price;

    Prize(int matches, String price) {
        this.matches = matches;
        this.price = price;
    }

    static String prizeInfo(Prize prize) {
        if (prize == SECOND) {
            return prize.matches + "개 일치, 보너스 볼 일치 " + "(" + prize.price + ")";
        }
        return prize.matches + "개 일치 " + "(" + prize.price + ")";
    }
}
