package lotto;

import lotto.userinterface.Hit;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Calculator {

    public static HashMap<Hit, Integer> getLottoResult(List<Lotto> randomLottos, Lotto answerLotto, Integer bonusNumber) {
        HashMap<Hit, Integer> result = getInitResult();
        Set<Lotto> answer = Set.of(answerLotto);

        for (Lotto randomLotto : randomLottos) {
            Set<Lotto> random = Set.of(randomLotto);
            random.retainAll(answer);

            Boolean bonusHit = random.contains(bonusNumber);

            Hit hit = Hit.getByCount(random.size(), bonusHit);
            result.put(hit, result.get(hit) + 1);
        }

        return result;
    }


    private static HashMap<Hit, Integer> getInitResult() {
        HashMap<Hit, Integer> result = new HashMap<>();

        result.put(Hit.THREE, 0);
        result.put(Hit.FOUR, 0);
        result.put(Hit.FIVE, 0);
        result.put(Hit.FIVE_BONUS, 0);
        result.put(Hit.SIZE, 0);

        return result;
    }
}
