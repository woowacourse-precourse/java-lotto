package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer(String won) {
        lottos = List.of();
    }

    private void validateIsUnderLottoPrice(int won) {
        if (won < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }
}
