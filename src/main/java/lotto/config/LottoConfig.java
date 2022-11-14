package lotto.config;

import lotto.UI.message.ErrorCode;

import java.util.List;

public class LottoConfig {
    public static final int LOTTO_PRICE = 1000;
    public static final List<Long> awards =
            List.of(2000000000L, 30000000L, 1500000L, 50000L, 5000L);

    public static void validate() throws IllegalArgumentException {
        try {
            assert(LOTTO_PRICE > 0);
            assert(awards.size() == 5);
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_LOTTO_PRICE.getValue());
        }
    }
}
