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
        MATCH6(6, "match6", 2000000000, "6개 일치 (2,000,000원) - $match6개"),
        // 당첨 번호 5개 일치 시, MATCH5_PLUS_BONUS와 MATCH5의 값이 겹치므로 MATCH5_PLUS_BONUS의 value를 사용하지 않는다.
        MATCH5_PLUS_BONUS(-1, "match5PlusBonus", 30000000, "6개 일치 (2,000,000원) - $match5PlusBonus개"),
        MATCH5(5, "match5", 1500000, "6개 일치 (2,000,000원) - $match5개"),
        MATCH4(4, "match4", 50000, "6개 일치 (2,000,000원) - $match4개"),
        MATCH3(3,"match3", 5000, "6개 일치 (2,000,000원) - $match3개");

        private final int winTypeValue;
        private final String winTypeKey;
        private final float prizeMoney;
        private final String winTypeMessage;

        WinType(int winTypeValue, String winTypeKey, float prizeMoney, String winTypeMessage) {
            this.winTypeValue = winTypeValue;
            this.winTypeKey = winTypeKey;
            this.prizeMoney = prizeMoney;
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

        for (WinType winType : WinType.values()) {
            if (containsBonusNumber && count == WinType.MATCH5.winTypeValue) {
                String key = WinType.MATCH5_PLUS_BONUS.winTypeKey;
                winRecords.put(key, winRecords.get(key) + 1);
            }
            else if (count == winType.winTypeValue) {
                String key = winType.winTypeKey;
                winRecords.put(key, winRecords.get(key) + 1);
            }
        }

        return winRecords;
    }
}

