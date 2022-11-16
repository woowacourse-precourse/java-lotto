package lotto.domain;

import lotto.constant.LottoAward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BunchOfLottos {
    private final List<Lotto> bunchOfLottos;
    private final String SEPARATOR = "\n";

    public BunchOfLottos(List<Lotto> bunchOfLottos) {
        this.bunchOfLottos = bunchOfLottos;
    }

    public Map<LottoAward, Integer> countLottoAward(WinningLotto winningLotto) {
        Map<LottoAward, Integer> bunchOfLottoAwards = new HashMap<>();

        for (Lotto lotto : bunchOfLottos) {
            LottoResult lottoResult = lotto.countMatchedNumber(winningLotto);
            LottoAward award = LottoAward.getAwardFrom(lottoResult);
            bunchOfLottoAwards.put(award, bunchOfLottoAwards.getOrDefault(award, 0) + 1);
        }

        return bunchOfLottoAwards;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : bunchOfLottos) {
            sb.append(lotto.toString()).append(SEPARATOR);
        }

        return sb.toString();
    }

    public static BunchOfLottos from(List<Lotto> bunchOfLottos) {
        return new BunchOfLottos(bunchOfLottos);
    }
}
