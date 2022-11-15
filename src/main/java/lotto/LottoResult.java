package lotto;

import java.util.List;

public class LottoResult {
    private int equalCount;
    private boolean isBonus;

    public void getResult(List<Lotto> lottos, WinNumber winNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            initValue();
            getEqualCount(lotto, winNumber.winNumbers);
            if (equalCount == 5) {
                getIsBonus(lotto, bonusNumber.bonusNumber);
            }
        }
    }

    private void initValue() {
        equalCount = 0;
        isBonus = false;
    }

    private void getEqualCount(Lotto lotto, List<Integer> winNumbers) {
        for (int i : lotto.getNumbers()) {
            if (winNumbers.contains(i)) {
                equalCount++;
            }
        }

        if (equalCount <= 2) {
            equalCount = 0;
        }
    }

    private void getIsBonus(Lotto lotto, int bonusNumber) {
        for (int i : lotto.getNumbers()) {
            if (i == bonusNumber) {
                isBonus = true;
            }
        }
    }
}
