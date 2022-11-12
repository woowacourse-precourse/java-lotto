package lotto.domain;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class LottoProfitRate {
    public double getProfitRate(double profit, int payment) {
        return Math.round((profit / payment) * LOTTO_PRICE) / 10.0;
    }
}