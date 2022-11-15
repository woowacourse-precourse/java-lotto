package lotto;

import java.text.DecimalFormat;

public enum LottoPrize {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    public int lottoPrize;

    LottoPrize(int lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    public int getLottoPrize() {
        return lottoPrize;
    }

    public String getLottotPrizeString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(lottoPrize);
    }
}
