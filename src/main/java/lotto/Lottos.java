package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    int LOTTO_PRICE = 1000;

    private final List<Lotto> boughtLottos = new ArrayList<>();
    private final int paid;

    public Lottos(int paid) {
        this.paid = paid;
        for (int i = 0; i < paid / LOTTO_PRICE; i++) {
            boughtLottos.add(Lotto.create());
        }
    }

    public List<Lotto> getBoughtLottos() {
        return boughtLottos;
    }

    public int getPaid() {
        return paid;
    }

    public Map<Score, Integer> getScore(List<Integer> winningNumbers, int bonusNumber) {
        Map<Score, Integer> result = setResult();
        for (Lotto lotto : boughtLottos) {
            Score score = lotto.getScore(winningNumbers, bonusNumber);
            if (score == Score.NOTHING) {
                continue;
            }
            result.put(score, result.getOrDefault(score, 0) + 1);
        }
        return result;
    }

    private Map<Score, Integer> setResult() {
        Map<Score, Integer> result = new HashMap<>();
        result.put(Score.FIRST, 0);
        result.put(Score.SECOND, 0);
        result.put(Score.THIRD, 0);
        result.put(Score.FOURTH, 0);
        result.put(Score.FIFTH, 0);
        return result;
    }
}
