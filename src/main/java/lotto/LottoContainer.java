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

    public double getRate(Map<LottoResult, Integer> matchMap) {
        Iterator<LottoResult> keys = matchMap.keySet().iterator();
        int totalPrice = 0;
        double rate = 0;

        while(keys.hasNext()) {
            LottoResult key = keys.next();
            totalPrice += key.getMoney() * matchMap.get(key);
        }
        rate = totalPrice / (lottos.size() * 10.0);

        return (rate * 10) / 10.0;
    }

    public void printResult(Map<LottoResult, Integer> matchMap) {
        System.out.println(LottoResult.FIFTH_PRIZE.getMessage() + matchMap.get(LottoResult.FIFTH_PRIZE) + "개");
        System.out.println(LottoResult.FOURTH_PRIZE.getMessage() + matchMap.get(LottoResult.FOURTH_PRIZE) + "개");
        System.out.println(LottoResult.THIRD_PRIZE.getMessage() + matchMap.get(LottoResult.THIRD_PRIZE) + "개");
        System.out.println(LottoResult.SECOND_PRIZE.getMessage() + matchMap.get(LottoResult.SECOND_PRIZE) + "개");
        System.out.println(LottoResult.FIRST_PRIZE.getMessage() + matchMap.get(LottoResult.FIRST_PRIZE) + "개");
        System.out.println("총 수익률은 " + getRate(matchMap) + "%입니다.");
    }

}
