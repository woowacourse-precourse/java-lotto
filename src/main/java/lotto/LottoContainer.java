package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLottos() {
        int size = lottos.size();
        System.out.println(size + "개를 구매했습니다.");
        for (Lotto lotto: lottos) {
            lotto.printNumbers();
        }
    }

    public Map<LottoResult, Integer> MatchAll(List<Integer> normalNumbers, int bonusNumber) {
        Map<LottoResult, Integer> matchMap = getNothingMatchResult();
        for(Lotto lotto: lottos) {
            LottoResult lottoResult = lotto.getResult(normalNumbers, bonusNumber);
            if (matchMap.containsKey(lottoResult)) {
                matchMap.put(lottoResult, matchMap.get(lottoResult) + 1);
            }
        }

        return matchMap;
    }

    public Map<LottoResult, Integer> getNothingMatchResult() {
        Map<LottoResult, Integer> matchMap = new HashMap<>();
        for(LottoResult lottoResult: LottoResult.values()) {
            matchMap.put(lottoResult, 0);
        }

        return matchMap;
    }

}
