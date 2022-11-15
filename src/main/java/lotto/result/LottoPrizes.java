package lotto.result;

import lotto.buy.Payment;

public enum LottoPrizes {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(-1, 0);
    private int indexNumber;
    private final int condition;
    private final int prizeMoney;
    private static int index = 0;
    LottoPrizes(int condition, int prizeMoney) {
        setIndex(this);
        this.condition = condition;
        this.prizeMoney = prizeMoney;
    }
    private void setIndex(LottoPrizes lottoPrizes) {
        lottoPrizes.indexNumber = index;
        index++;
    }
    public static LottoPrizes prizes(int condition, boolean hasBonus) {
        if (condition == 5 && hasBonus) {
            return SECOND;
        }
        return prizes(condition);
    }
    public static LottoPrizes prizes(int condition) {
        for (LottoPrizes prize : LottoPrizes.values()) {
            if (prize.equals(SECOND)) {
                continue;
            }
            if (prize.condition == condition) {
                return prize;
            }
        }
        return NOTHING;
    }
    public int index() {
        return indexNumber;
    }
    public double money() {
        return prizeMoney;
    }
    public static double purchasingPrice() {
        return Payment.LOTTO_PRICE;
    }
    public int getCondition() {
        return condition;
    }
}
