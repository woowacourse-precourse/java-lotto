package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoStore {
    private static final int START_INDEX = 0;
    private static final int LOTTO_AMOUNT_UNIT = 1000;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public List<Lotto> buy(int purchaseAmount) {
        int lottoCount = convertPurchaseAmountToLottoCount(purchaseAmount);
        IntStream.range(START_INDEX, lottoCount)
                .forEach(value -> lottoTickets.add(new Lotto(LottoGenerator.generate())));

        return lottoTickets;
    }

    private int convertPurchaseAmountToLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_AMOUNT_UNIT;
    }
}
