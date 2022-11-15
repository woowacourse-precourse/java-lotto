package lotto;

import java.util.HashMap;
import java.util.List;

public class Match {
    int MATCH_THREE;
    int MATCH_FOUR;
    int MATCH_FIVE;
    int MATCH_SIX;
    int MATCH_FIVE_BONUS;

    public Match() {
        initialize();
    }

    public Match(List<Lotto> lottos, List<Integer> winning, int bonus) {
        initialize();
        count(lottos, winning, bonus);
    }

    private void initialize() {
        MATCH_THREE = 0;
        MATCH_FOUR = 0;
        MATCH_FIVE = 0;
        MATCH_SIX = 0;
        MATCH_FIVE_BONUS = 0;
    }

    private void countWinning(Lotto lotto, int bonus, int matchCount) {
        if (matchCount == 3) {
            MATCH_THREE += 1;
        } else if (matchCount == 4) {
            MATCH_FOUR += 1;
        } else if (!(lotto.matchBonus(bonus)) && (matchCount == 5)) {
            MATCH_FIVE += 1;
        } else if ((lotto.matchBonus(bonus)) && (matchCount == 5)) {
            MATCH_FIVE_BONUS += 1;
        } else if (matchCount == 6) {
            MATCH_SIX += 1;
        }
    }

    public void count(List<Lotto> lottos, List<Integer> winning, int bonus) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchWinning(winning);
            countWinning(lotto, bonus, matchCount);
        }
    }

    public HashMap<String, Integer> bundle() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("match3", MATCH_THREE);
        result.put("match4", MATCH_FOUR);
        result.put("match5", MATCH_FIVE);
        result.put("match6", MATCH_SIX);
        result.put("match5Bonus", MATCH_FIVE_BONUS);
        return result;
    }
}
