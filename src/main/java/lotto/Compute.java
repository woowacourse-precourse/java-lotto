package lotto;

/*
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
 */

import java.util.HashMap;
import java.util.List;

public class Compute {
    private enum WinType {
        MATCH6("match6", "6개 일치 (2,000,000원) - $match6개"),
        MATCH5_PLUS_BONUS("match5PlusBonus", "6개 일치 (2,000,000원) - $match5PlusBonus개"),
        MATCH5("match5", "6개 일치 (2,000,000원) - $match5개"),
        MATCH4("match4", "6개 일치 (2,000,000원) - $match4개"),
        MATCH3("match3", "6개 일치 (2,000,000원) - $match3개");

        private final String winTypeKey;
        private final String winTypeMessage;

        WinType(String winTypeKey, String winTypeMessage) {
            this.winTypeKey = winTypeKey;
            this.winTypeMessage = winTypeMessage;
        }
    }

    private HashMap<String, Integer> initializeWinRecords() {
        HashMap<String, Integer> winRecords = new HashMap<>();

        for (WinType winType : WinType.values()) {
            winRecords.put(winType.winTypeKey, 0);
        }
        return winRecords;
    }

    private HashMap<String, Integer> computeWinRecords(
            HashMap<String, Integer> winRecords,
            List<Integer> lotto,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        boolean containsBonusNumber = lotto.contains(bonusNumber);

        List<Integer> matchingNumbers = lotto;
        matchingNumbers.retainAll(winningNumbers);
        int count = matchingNumbers.size();

        if (count == 6) {
            String key = WinType.MATCH6.winTypeKey;
            winRecords.put(key, winRecords.get(key) + 1);
        }
        else if (count == 5 && containsBonusNumber) {
            String key = WinType.MATCH5_PLUS_BONUS.winTypeKey;
            winRecords.put(key, winRecords.get(key) + 1);
        }
        else if (count == 5) {
            String key = WinType.MATCH5.winTypeKey;
            winRecords.put(key, winRecords.get(key) + 1);
        }
        else if (count == 4) {
            String key = WinType.MATCH4.winTypeKey;
            winRecords.put(key, winRecords.get(key) + 1);
        }
        else if (count == 3) {
            String key = WinType.MATCH3.winTypeKey;
            winRecords.put(key, winRecords.get(key) + 1);
        }

        return winRecords;
    }
}

