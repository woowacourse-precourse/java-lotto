package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.model.Result.*;

public class LottoResult {
    private int equalCount;
    private boolean isBonus;

    private Map<Result, Integer> resultMap = new HashMap<>();

    public void getResult(List<Lotto> lottos, WinNumber winNumber, BonusNumber bonusNumber) {
        initResultMap();

        for (Lotto lotto : lottos) {
            initValue();
            getEqualCount(lotto, winNumber.winNumbers);

            if (equalCount == 5) {
                getIsBonus(lotto, bonusNumber.bonusNumber);
            }

            Result result = getMatchResult(equalCount, isBonus);
            if (resultMap.containsKey(result)) {
                resultMap.put(result, resultMap.get(result) + 1);
            }
        }
    }

    public double getEarning(int price) {
        int totalReward = 0;
        for (Result result : resultMap.keySet()) {
            totalReward += resultMap.get(result) * result.getReward();
        }
        return (double) totalReward / price * 100;
    }

    private void initValue() {
        equalCount = 0;
        isBonus = false;
    }

    private void initResultMap() {
        resultMap.put(FIRST, 0);
        resultMap.put(SECOND, 0);
        resultMap.put(THIRD, 0);
        resultMap.put(FOURTH, 0);
        resultMap.put(FIFTH, 0);
    }

    private void getEqualCount(Lotto lotto, List<Integer> winNumbers) {
        for (int i : lotto.getNumbers()) {
            if (winNumbers.contains(i)) {
                equalCount++;
            }
        }
    }

    private void getIsBonus(Lotto lotto, int bonusNumber) {
        for (int i : lotto.getNumbers()) {
            if (i == bonusNumber) {
                isBonus = true;
                break;
            }
        }
    }

    public Map<Result, Integer> getResultMap() {
        return resultMap;
    }
}
