package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int ONE_LOTTO_PRICE = 1000;
    public static List<Lotto> makeLotto(int price) {
        validate(price);
        return Collections.emptyList();
    }

    private static void validate(int price) {
        if (price % ONE_LOTTO_PRICE != 0)
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다.");
    }
}
