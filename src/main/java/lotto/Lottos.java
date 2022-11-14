package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int PRICE_PER_ONE_LOTTO = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoPrice() {
        return lottos.size() * PRICE_PER_ONE_LOTTO;
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = initLottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getCountOfMatch(winningLotto.getWinningLottoNumbers());
            boolean bonusMatch = lotto.containBonus(winningLotto.getBonusNumber());
            LottoRank lottoRank = LottoRank.valueOf(matchCount, bonusMatch);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }

        return new LottoResult(lottoResult);
    }

    private Map<LottoRank, Integer> initLottoResult() {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(LottoRank.FIRST_PLACE, 0);
        lottoResult.put(LottoRank.SECOND_PLACE, 0);
        lottoResult.put(LottoRank.THIRD_PLACE, 0);
        lottoResult.put(LottoRank.FOURTH_PLACE, 0);
        lottoResult.put(LottoRank.FIFTH_PLACE, 0);
        lottoResult.put(LottoRank.NOTHING, 0);

        return lottoResult;
    }
}
