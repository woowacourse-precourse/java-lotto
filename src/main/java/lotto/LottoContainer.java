package lotto;

import java.util.HashMap;
import java.util.Iterator;
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

    public void matchAll(List<Integer> normalNumbers, int bonusNumber) {
        Map<LottoResult, Integer> matchMap = getNothingMatchResult();
        for(Lotto lotto: lottos) {
            LottoResult lottoResult = lotto.getResult(normalNumbers, bonusNumber);
            if (matchMap.containsKey(lottoResult)) {
                matchMap.put(lottoResult, matchMap.get(lottoResult) + 1);
            }
        }

        printResult(matchMap);
    }

    public Map<LottoResult, Integer> getNothingMatchResult() {
        Map<LottoResult, Integer> matchMap = new HashMap<>();
        for(LottoResult lottoResult: LottoResult.values()) {
            matchMap.put(lottoResult, 0);
        }

        return matchMap;
    }

    public void printResult(Map<LottoResult, Integer> matchMap) {
        Iterator<LottoResult> results = matchMap.keySet().iterator();

        while(results.hasNext()) {
            LottoResult key = results.next();
            System.out.println(key.getMessage() + matchMap.get(key) + "개");
        }
    }

}
