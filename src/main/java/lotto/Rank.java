package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rank {
    enum Grade {
        THREE(3, 5000, false),
        FOUR(4, 50000, false),
        FIVE(5, 1500000, false),
        FIVE_BONUS(5, 30000000, true),
        SIX(6, 2000000000, false);

        private final int matchCount;
        private final long prize;
        private final boolean check;

        Grade(int matchCount, long prize, boolean check) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.check = check;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public long getPrize() {
            return prize;
        }

        public boolean isCheck() {
            return check;
        }
    }

    public static Map<Integer, Integer> initializeResult() {
        Map<Integer, Integer> result = new TreeMap<>();
        for (int key = 3; key < 8; key++) {
            result.put(key, 0);
        }
        return result;
    }

    public static Map<Integer, Integer> getResult (Lotto winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        Map<Integer, Integer> result = initializeResult();
        for (Lotto lotto : lottoList) {
            int numberKey = Lotto.compareNumbers(winningNumbers, lotto);
            result.putAll(putNumberKey(numberKey, lotto, bonusNumber));
        }
        return result;
    }

    public static Map<Integer, Integer> putNumberKey (int key, Lotto lotto, int bonusNumber) {
        Map<Integer, Integer> result = new TreeMap<>();
        if (key > 2) {
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        if (key == 5 && Lotto.hasBonusNumber(bonusNumber, lotto)) {
            result.put(7, result.getOrDefault(7, 0) + 1);
            result.put(key, result.getOrDefault(key, 0) - 1);
        }
        return result;
    }

}
