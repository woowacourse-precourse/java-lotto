package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rank {

    enum Grade {
        THREE(3, "5,000", false),
        FOUR(4, "50,000", false),
        FIVE(5, "1,500,000", false),
        FIVE_BONUS(5, "30,000,000", true),
        SIX(6, "2,000,000,000", false);

        private final int matchCount;
        private final String prize;
        private final boolean check;

        Grade(int matchCount, String prize, boolean check) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.check = check;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public String getPrize() {
            return prize;
        }

        public boolean isCheck() {
            return check;
        }
    }

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
