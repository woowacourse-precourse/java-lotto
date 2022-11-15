package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparison {
    public static Map<Integer, Integer> compareLotto = new HashMap<>();

    public static void sliceBundle(List<Lotto> lottoBundle, List<Integer> winningNumber) {
        for (int i = 0; i < lottoBundle.size(); i++) {
            compareNumbers(lottoBundle.get(i), winningNumber);
        }
    }

    public static void compareNumbers(Lotto lotto, List<Integer> winningNumber) {
        int cnt = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winningNumber.contains(lotto.getNumbers().get(i))) {
                cnt++;
            }
        }
        compareLotto.put(cnt, compareLotto.getOrDefault(cnt, 0) + 1);
    }
}
