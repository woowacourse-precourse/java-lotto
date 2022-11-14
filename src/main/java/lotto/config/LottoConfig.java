package lotto.config;

import java.util.List;

public class LottoConfig {
    public static final int LOTTO_PRICE = 1000;
    public static final List<Integer> awards =
            List.of(2000000000, 30000000, 1500000, 50000, 5000);
    public static final List<String> awardsToString =
            List.of("2,000,000,000", "30,000,000", "1,500,000", "50,000", "5,000");
}
