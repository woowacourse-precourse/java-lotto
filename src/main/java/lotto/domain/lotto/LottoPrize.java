package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000"),
    DEFAULT(0, false, "0");

    private final long count;
    private final boolean hasBonus;
    private final String moneyFormat;

    LottoPrize(long count, boolean bonusNumber, String moneyFormat) {
        this.count = count;
        this.hasBonus = bonusNumber;
        this.moneyFormat = moneyFormat;
    }

    public static LottoPrize checkPrize(long count, boolean hasBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.count == count && prize.hasBonus == hasBonus)
                .findAny()
                .orElse(DEFAULT);
    }

    @Override
    public String toString() {
        if (hasBonus) {
            return String.format("%d개 일치, 보너브 볼 일치 (%s원) - ", count, moneyFormat);
        }
        return String.format("%d개 일치, (%s원) - ", count, moneyFormat);
    }
}