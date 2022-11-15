package lotto.domain;

public enum Prize {
    LOSING_TICKET(0, 0, " 0"),
    FIFTH_PLACE(3, 5000, " (5,000원)"),
    FOURTH_PLACE(4, 50000, " (50,000원)"),
    THIRD_PLACE(5, 1500000, " (1,500,000원)"),
    SECOND_PLACE(5, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE(6, 2000000000, " (2,000,000,000원)");

    private final int matchN;
    private final int amount;
    private final String stringAmount;

    Prize(int place, int amount, String stringAmount) {
        this.matchN = place;
        this.amount = amount;
        this.stringAmount = stringAmount;
    }

    public static Prize winHistory(int matchN, int bonusN) {
        if (matchN == 6)
            return FIRST_PLACE;
        if (matchN == 5 && bonusN == 1)
            return SECOND_PLACE;
        if (matchN == 5 && bonusN == 0)
            return THIRD_PLACE;
        if (matchN == 4)
            return FOURTH_PLACE;
        if (matchN == 3)
            return FIFTH_PLACE;

        return LOSING_TICKET;
    }

    public int getMatchN() {
        return matchN;
    }

    public int getAmount() {
        return amount;
    }

    public String getStringAmount() {
        return stringAmount;
    }
}
