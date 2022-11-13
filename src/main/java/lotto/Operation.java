package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operation {
    static final int MATCH3 = 3;
    static final int MATCH4 = 4;
    static final int MATCH5 = 5;
    static final int MATCH6 = 6;
    static final int MATCH5_BONUS = 0;

    static List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < (amount / 1000); i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int random = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    static HashMap<Integer, Integer> calculateMatches(List<Lotto> lottos, List<Integer> winning, int bonus) {
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(MATCH3, 0);
        result.put(MATCH4, 0);
        result.put(MATCH5, 0);
        result.put(MATCH6, 0);
        result.put(MATCH5_BONUS, 0);

        for (Lotto lotto : lottos) {
            int match = lotto.matchWinning(winning);
            if (lotto.matchBonus(bonus)) {
                if (match == 5) {
                    int value = result.get(MATCH5_BONUS) + 1;
                    result.put(MATCH5_BONUS, value);
                }
            }
            if (match == MATCH3) {
                int value = result.get(MATCH3) + 1;
                result.put(MATCH3, value);
            }
            if (match == MATCH4) {
                int value = result.get(MATCH4) + 1;
                result.put(MATCH4, value);
            }
            if (match == MATCH5) {
                int value = result.get(MATCH5) + 1;
                result.put(MATCH5, value);
            }
            if (match == MATCH6) {
                int value = result.get(MATCH6) + 1;
                result.put(MATCH6, value);
            }
        }
        return result;
    }
}
