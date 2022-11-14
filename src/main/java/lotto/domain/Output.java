package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Output {
    public HashMap<Integer, Integer> countOfPrize = new HashMap<>();
    public HashMap<Integer, Integer> createMakeOfPrize (List<Integer> winningTable) {
        for (int result : winningTable) {
            countOfPrize.put(result, countOfPrize.getOrDefault(result, 0) + 1);
        }
        return countOfPrize;
    }
}
