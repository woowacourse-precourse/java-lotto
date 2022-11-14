package lotto.result;

import lotto.buy.Payment;

public enum LottoPrizes {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000),
    NOTHING(0, -1, 0);
    private final int indexNumber;
    private final int condition;
    private final int prizeMoney;
    LottoPrizes(int indexNumber, int condition, int prizeMoney) {
        this.indexNumber = indexNumber;
        this.condition = condition;
        this.prizeMoney = prizeMoney;
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
