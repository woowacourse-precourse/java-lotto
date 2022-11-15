package lotto;

import java.util.HashMap;
import java.util.List;

public class Match {
    int match3;
    int match4;
    int match5;
    int match6;
    int match5Bonus;

    public Match() {
        initialize();
    }

    public Match(List<Lotto> lottos, List<Integer> winning, int bonus) {
        initialize();
        count(lottos, winning, bonus);
    }

    private void initialize() {
        match3 = 0;
        match4 = 0;
        match5 = 0;
        match6 = 0;
        match5Bonus = 0;
    }

    private void countWinning(Lotto lotto, int bonus, int matchCount) {
        if (matchCount == 3) {
            match3 += 1;
        } else if (matchCount == 4) {
            match4 += 1;
        } else if (!(lotto.matchBonus(bonus)) && (matchCount == 5)) {
            match5 += 1;
        } else if ((lotto.matchBonus(bonus)) && (matchCount == 5)) {
            match5Bonus += 1;
        } else if (matchCount == 6) {
            match6 += 1;
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
        result.put("match3", match3);
        result.put("match4", match4);
        result.put("match5", match5);
        result.put("match6", match6);
        result.put("match5Bonus", match5Bonus);
        return result;
    }
}