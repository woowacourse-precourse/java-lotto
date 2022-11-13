package lotto.domain;

import java.util.List;

public class LotteryShop {
    private static final int LOTTO_PRICE = 1000;
    private int lottoCnt;
    public List<Integer> lottoNum;

    public LotteryShop(int totalPayment) {
        countLotto(totalPayment);
    }

    private void countLotto(int totalPayment) {
        validate(totalPayment);
        lottoCnt = totalPayment / LOTTO_PRICE;
    }

    private void validate(int totalPayment) {
        if (totalPayment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        if (totalPayment - LOTTO_PRICE < 0) {
            throw new IllegalArgumentException();
        }
    }
}
