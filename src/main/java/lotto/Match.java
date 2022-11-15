package lotto;

import java.util.List;

import static lotto.matchType.*;

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
        countAll(lottos, winning, bonus);
    }

    private void initialize() {
        MATCH_THREE = 0;
        MATCH_FOUR = 0;
        MATCH_FIVE = 0;
        MATCH_SIX = 0;
        MATCH_FIVE_BONUS = 0;
    }

    private void countEach(matchType type) {
        if (type == THREE) {
            MATCH_THREE += 1;
        } else if (type == FOUR) {
            MATCH_FOUR += 1;
        } else if (type == FIVE) {
            MATCH_FIVE += 1;
        } else if (type == FIVE_BONUS) {
            MATCH_FIVE_BONUS += 1;
        } else if (type == SIX) {
            MATCH_SIX += 1;
        }
    }

    public void countAll(List<Lotto> lottos, List<Integer> winning, int bonus) {
        for (Lotto lotto : lottos) {
            lotto.compare(winning, bonus);
            matchType type = lotto.getType();
            countEach(type);
        }
    }
}
