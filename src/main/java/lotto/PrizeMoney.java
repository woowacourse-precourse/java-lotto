package lotto;

import java.text.DecimalFormat;

public enum PrizeMoney {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    ;

    public final int value;
    PrizeMoney(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(value);
    }
}
