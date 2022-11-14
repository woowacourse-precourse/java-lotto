package lotto;

import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinnerLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static lotto.model.Lotto.createLotto;

public class LottoService {

    private Map<LottoRank, Integer> lottoResult;

    public LottoService() {
        this.lottoResult = new TreeMap<>();
        for (LottoRank value : LottoRank.values()) {
            lottoResult.put(value, 0);
        }
    }

    public List<Lotto> create(Amount amount) {
        int count = amount.getLottoCount();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    public void compare(List<Lotto> lottos, WinnerLotto winnerLotto) {
        for (Lotto lotto : lottos) {
            long count = winnerLotto.matchNumbers(lotto);
            boolean isBonus = winnerLotto.matchBonus(lotto);
        }
    }
}

