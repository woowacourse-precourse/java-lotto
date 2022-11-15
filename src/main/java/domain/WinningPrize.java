package domain;

import java.text.DecimalFormat;

public enum WinningPrize {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private final int prize;

    WinningPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getStringPrize() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(this.prize);
    }
}
