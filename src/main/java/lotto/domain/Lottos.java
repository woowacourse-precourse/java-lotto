package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoWin, Integer> lottoResults(LottoWinNumber lottoWinNumber) {
        Map<LottoWin, Integer> lottoResults = new HashMap<>();
        Arrays.stream(LottoWin.values())
                        .forEach(lottoWin -> lottoResults.put(lottoWin, 0));
        lottos.stream()
                .map(lottoWinNumber::compareWith)
                .forEach(lottoWin -> lottoResults.put(lottoWin, lottoResults.getOrDefault(lottoWin, 0) + 1));
        return lottoResults;
    }
}
