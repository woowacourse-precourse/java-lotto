package lotto;

import java.util.List;
import java.util.Map;

import static lotto.Result.*;

public class LottoResult {
    private int equalCount;
    private boolean isBonus;

    private Map<Result, Integer> lottoResult;

    public void getResult(List<Lotto> lottos, WinNumber winNumber, BonusNumber bonusNumber) {
        initLottoResult();

        for (Lotto lotto : lottos) {
            initValue();
            getEqualCount(lotto, winNumber.winNumbers);

            if (equalCount == 5) {
                getIsBonus(lotto, bonusNumber.bonusNumber);
            }

            Result result = getMatchResult(equalCount, isBonus);
            if (lottoResult.containsKey(result)) {
                lottoResult.put(result, lottoResult.get(result) + 1);
            }
        }
    }

    public double getEarning(int price) {
        int totalReward = 0;
        for (Result result : lottoResult.keySet()) {
            totalReward += lottoResult.get(result) * result.getReward();
        }
        return (double) totalReward / price * 100;
    }

    private void initValue() {
        equalCount = 0;
        isBonus = false;
    }

    private void initLottoResult() {
        lottoResult.put(FIRST, 0);
        lottoResult.put(SECOND, 0);
        lottoResult.put(THIRD, 0);
        lottoResult.put(FOURTH, 0);
        lottoResult.put(FIFTH, 0);
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

    public Map<Result, Integer> getLottoResult() {
        return lottoResult;
    }
}
