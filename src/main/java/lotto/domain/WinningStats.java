package lotto.domain;

import java.util.*;

public class WinningStats {
    private final LinkedHashMap<String, Integer> winningStats;
    public WinningStats(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> purchasedLottos) {
        LinkedHashMap<String, Integer> winningStats = new LinkedHashMap<>() {{
            put("FIFTH", 0);
            put("FOURTH", 0);
            put("THIRD", 0);
            put("SECOND", 0);
            put("FIRST", 0);
        }};

        for (List<Integer> lotto : purchasedLottos) {
            int count = matchNumbers(winningNumbers, bonusNumber, lotto);
            if (count < 3) {
                continue;
            }
            addStats(count, winningStats);
        }
        this.winningStats = winningStats;
    }

    private String getKey(int count) {
        if (count == 3) {
            return "FIFTH";
        }
        if (count == 4) {
            return "FOURTH";
        }
        if (count == 5) {
            return "THIRD";
        }
        if (count == 6) {
            return "SECOND";
        }
        if (count == 7) {
            return "FIRST";
        }
        return "";
    }

    private void addStats(int count, LinkedHashMap<String, Integer> winningStats) {
        if (count < 3 || count > 7)
            return;
        String key = getKey(count);
        winningStats.put(key, winningStats.get(key) + 1);
    }

    private int matchNumbers(List<Integer> winningNumbers, int bonusNumber, List<Integer> lotto) {
            int count = 0;

            for (Integer number : lotto) {
                if (winningNumbers.contains(number))
                    count++;
            }
            if (count == 5 && lotto.contains(bonusNumber)) {
                count++;
            }
            if (count == 6 && !lotto.contains(bonusNumber)) {
                count++;
            }
            return count;
    }
    public LinkedHashMap<String, Integer> getStats() {
        return this.winningStats;
    }
}
