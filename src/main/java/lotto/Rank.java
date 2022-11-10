package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rank {

    public static Map<Integer, Integer> getResult (List<Integer> winningNumbers, List<Lotto> lottoList) {
        Map<Integer, Integer> result = new TreeMap<>();
        for (Lotto lotto : lottoList) {
            int key = Lotto.compareNumbers(winningNumbers, lotto);
            result.putAll(putRankKey(key, lotto));
        }
        return result;
    }

    public static Map<Integer, Integer> putRankKey (int key, Lotto lotto) {
        Map<Integer, Integer> result = new TreeMap<>();
        if (key > 3) {
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

}
