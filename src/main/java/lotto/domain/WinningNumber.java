package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {
    public static int winningCount;
    public static void getWinningResult(List<List<Integer>> lottos, List<Integer> winningNumbers) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (List<Integer> check : lottos) {
            winningCount = 0;
            checkCount(check, winningNumbers, map);
        }
        winningCount = Collections.max(map.values());
    }

    private static void checkCount(List<Integer> check, List<Integer> winningNumbers, Map<List<Integer>, Integer> map) {
        for (int i = 0; i < check.size(); i++) {
            if (check.contains(winningNumbers.get(i))) {
                winningCount++;
                map.put(check, winningCount);
            }
        }
    }
}
