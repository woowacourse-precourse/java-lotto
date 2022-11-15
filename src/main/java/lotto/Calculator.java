package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Calculator {

    public static HashMap<Hit, Integer> getLottoResult(List<Lotto> randomLottos, Lotto answerLotto, Integer bonusNumber) {
        HashMap<Hit, Integer> result = getInitResult();
        List<Integer> answerNumbers = new ArrayList<>(answerLotto.getNumbers());

        for (Lotto randomLotto : randomLottos) {
            List<Integer> randomNumbers = new ArrayList<>(randomLotto.getNumbers());
            Boolean hasBonus = randomNumbers.contains(bonusNumber);

            randomNumbers.retainAll(answerNumbers);

            Hit hit = Hit.getHit(randomNumbers.size(), hasBonus);

            if (hit != null) {
                result.put(hit, result.get(hit) + 1);
            }
        }

        return result;
    }

    private static HashMap<Hit, Integer> getInitResult() {
        HashMap<Hit, Integer> result = new LinkedHashMap<>();

        result.put(Hit.THREE, 0);
        result.put(Hit.FOUR, 0);
        result.put(Hit.FIVE, 0);
        result.put(Hit.FIVE_BONUS, 0);
        result.put(Hit.SIX, 0);

        return result;
    }

    public static float getEarningRate(HashMap<Hit, Integer> result, Integer money) {
        Integer totalEarning = 0;

        for (Hit hit : result.keySet()) {
            Integer hitCount = result.get(hit);
            totalEarning += hitCount * parseToInt(hit.getPrize());
        }

        return totalEarning / (float) money * 100;
    }

    private static Integer parseToInt(String prize) {
        return Integer.parseInt(String.join("", prize.split(",")));
    }
}
