package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinnerLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static lotto.domain.Lotto.createLotto;

public class LottoService {

    private Map<LottoRank, Integer> rankResult;

    public LottoService() {
        this.rankResult = new TreeMap<>();
        for (LottoRank value : LottoRank.values()) {
            rankResult.put(value, 0);
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

    public Map<LottoRank, Integer> compare(List<Lotto> lottos, WinnerLotto winnerLotto) {
        for (Lotto lotto : lottos) {
            LottoRank rank = winnerLotto.matchAll(lotto);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }
}


