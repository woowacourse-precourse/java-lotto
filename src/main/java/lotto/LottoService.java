package lotto;

import lotto.model.Amount;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.createLotto;

public class LottoService {

    public List<Lotto> create(Amount amount) {
        int count = amount.getLottoCount();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }
}

