package lotto;

import java.text.DecimalFormat;

public enum WinningAmount {

    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000);

    private final int amount;

    WinningAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getAmountToDecimalFormatString() {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(amount);
    }
}
