package lotto.domain;

import lotto.constant.LottoAward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCollection {
    private final List<Lotto> lottos;
    private final String SEPARATOR = "\n";

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoAward, Integer> countLottoAward(WinningLotto winningLotto) {
        Map<LottoAward, Integer> groupOfLottoAward = new HashMap<>();

        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lotto.countMatchedNumber(winningLotto);
            LottoAward award = LottoAward.getAwardFrom(lottoResult);
            groupOfLottoAward.put(award, groupOfLottoAward.getOrDefault(award, 0) + 1);
        }

        return groupOfLottoAward;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append(SEPARATOR);
        }

        return sb.toString();
    }

    public static LottoCollection of(List<Lotto> lottos) {
        return new LottoCollection(lottos);
    }
}
