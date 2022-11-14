package lotto.domain;

import lotto.util.NumberFormator;

public enum Prize {
    FIFTH(3, 5_000, Boolean.FALSE),
    FOURTH(4, 50_000, Boolean.FALSE),
    THIRD(5, 1_500_000, Boolean.FALSE),
    SECOND(5, 30_000_000, Boolean.TRUE),
    FIRST(6, 2_000_000_000, Boolean.FALSE);

    private final int money;
    private final int numberOfMatch;
    private final boolean hasBonusNumber;

    Prize(int numberOfMatch, int money, boolean hasBonusNumber) {
        this.numberOfMatch = numberOfMatch;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(numberOfMatch).append("개 일치");

        if (hasBonusNumber) {
            message.append(", 보너스 볼 일치");
        }

        message.append(" (").append(NumberFormator.divideEvery3Digits(money)).append("원)");

        return message.toString();
    }
}
