package lotto.constant;

import java.text.DecimalFormat;

public enum WinningAmount {
    MATCH3(5000) ,MATCH4(50000), MATCH5(1500000), MATCH5BONUS(30000000), MATCH6(2000000000);

    private final int value;
    WinningAmount(int value) {
        this.value = value;
    }

    public String getValueString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(value);
    }

    public int getValue() {
        return value;
    }
}

