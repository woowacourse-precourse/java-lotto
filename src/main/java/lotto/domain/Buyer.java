package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer(String won) {
        lottos = List.of();
    }

    private int calculateNumberOfLottos(String won) {
        int wonParseToInt = Integer.parseInt(won);
        validateIsUnderLottoPrice(wonParseToInt);
        int wonRoundDownLottoPriceUnits = roundDownLottoPriceUnits(wonParseToInt);
        return wonRoundDownLottoPriceUnits / LOTTO_PRICE;
    }

    private void validateIsUnderLottoPrice(int won) {
        if (won < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    private int roundDownLottoPriceUnits(int won) {
        return won - (won % LOTTO_PRICE);
    }
}
