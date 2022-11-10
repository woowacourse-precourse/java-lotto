package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rank {

    public static Map<Integer, Integer> getResult (List<Integer> winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        Map<Integer, Integer> result = new TreeMap<>();
        for (Lotto lotto : lottoList) {
            int numberKey = Lotto.compareNumbers(winningNumbers, lotto);
            result.putAll(putNumberKey(numberKey, lotto, bonusNumber));
        }
        return result;
    }

    public static Map<Integer, Integer> putNumberKey (int key, Lotto lotto, int bonusNumber) {
        Map<Integer, Integer> result = new TreeMap<>();
        if (key > 3) {
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        if (key == 5 && Lotto.isBonusNumber(bonusNumber, lotto)) {
            result.put(7, result.getOrDefault(7, 0) + 1);
            result.put(key, result.getOrDefault(key, 0) - 1);
        }
        return result;
    }

}
