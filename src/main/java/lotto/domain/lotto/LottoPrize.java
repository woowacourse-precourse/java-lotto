package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoPrize {
    FIFTH(3, false, "5,000", 5000),
    FOURTH(4, false, "50,000", 50000),
    THIRD(5, false, "1,500,000", 1500000),
    SECOND(5, true, "30,000,000", 30000000),
    FIRST(6, false, "2,000,000,000", 2000000000),
    DEFAULT(0, false, "0", 0);

    private final long count;
    private final long reward;
    private final boolean hasBonus;
    private final String moneyFormat;

    LottoPrize(long count, boolean bonusNumber, String moneyFormat, long reward) {
        this.count = count;
        this.reward = reward;
        this.hasBonus = bonusNumber;
        this.moneyFormat = moneyFormat;
    }

    public static LottoPrize checkPrize(long count, boolean hasBonus) {
        if (hasBonus && count == 5) {
            return LottoPrize.SECOND;
        } else {
            return Arrays.stream(LottoPrize.values())
                    .filter(prize -> prize.count == count)
                    .findAny()
                    .orElse(DEFAULT);
        }
    }

    public long getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        if (hasBonus) {
            return String.format("%d개 일치, 보너브 볼 일치 (%s원)", count, moneyFormat);
        }
        return String.format("%d개 일치, (%s원)", count, moneyFormat);
    }
}