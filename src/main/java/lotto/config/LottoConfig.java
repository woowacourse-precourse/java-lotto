package lotto.config;

import lotto.IO.message.ErrorCode;

import java.util.List;

public class LottoConfig {
    public static final int LOTTO_PRICE = 1000;
    public static final List<Integer> awards =
            List.of(2000000000, 30000000, 1500000, 50000, 5000);

    public static void validate() throws IllegalArgumentException {
        try {
            assert(LOTTO_PRICE > 0);
            assert(awards.size() == 5);
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_LOTTO_PRICE.getValue());
        }
    }
}
