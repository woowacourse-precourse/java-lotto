package lotto;

public enum Prize {
    SIX(2000000000, "6개 일치 (2,000,000,000원)"),
    FIVE_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIVE(1500000, "5개 일치 (1,500,000원)"),
    FOUR(50000, "4개 일치 (50,000원)"),
    THREE(5000, "3개 일치 (5,000원)"),
    UNDER_TWO(0, ""),
    ;

    private int money;
    private String announce;

    Prize(int i, String s) {
        money = i;
        announce = s;
    }

    public static Prize getPrize(int result, boolean isBonusRight) {
        if (result == 6) {
            return SIX;
        }
        if (result == 5) {
            if (isBonusRight) {
                return FIVE_BONUS;
            }
            return FIVE;
        }
        if (result == 4) {
            return FOUR;
        }
        if (result == 3) {
            return THREE;
        }
        return UNDER_TWO;
    }

    public int getMoney() {
        return money;
    }

    public String getAnnounce() {
        return announce;
    }
}
