package lotto;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.createLotto;

public class LottoService {
    private static final int LOTTO_AMOUNT = 1000;

    public List<Lotto> create(int inputAmount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < getLottoCount(inputAmount); i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    private int getLottoCount(int inputAmount) {
        return inputAmount / LOTTO_AMOUNT;
    }
}

