package lotto;

public enum Prize {
    SIX(2000000000, "6개 일치 (2,000,000,000원)"),
    FIVE_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIVE(1500000, "5개 일치 (1,500,000원)"),
    FOUR(50000, "4개 일치 (50,000원)"),
    THREE(5000, "3개 일치 (5,000원)"),
    ;

    private int money;
    private String announce;

    Prize(int i, String s) {
        money = i;
        announce = s;
    }

    public int getMoney() {
        return money;
    }

    public String getAnnounce() {
        return announce;
    }
}
