package lotto.domain;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class LottoProfitRate {
    public double getProfitRate(long profit, int payment) {
        return Math.round((profit / (double) payment) * LOTTO_PRICE) / 10.0;
    }
}