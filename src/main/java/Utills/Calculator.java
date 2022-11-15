package Utills;

import java.util.List;

public class Calculator {

    private int sameCmt;
    private int bonusCorrect;

    public void calculate(List<Integer> purchasedLotto, List<Integer> winningLotto, int bonusNumber) {
        initializedValues();
        sameCmt = comparePurchasedWithWinningLotto(purchasedLotto, winningLotto);
        if (sameCmt == 5) {
            if (purchasedLotto.contains(bonusNumber)) {
                bonusCorrect++;
            }
        }
    }

    private void initializedValues() {
        sameCmt = 0;
        bonusCorrect = 0;
    }

    private int comparePurchasedWithWinningLotto(List<Integer> purchasedLotto, List<Integer> winningLotto) {
        for (Integer purchasedLottoNumber : purchasedLotto) {
            if (winningLotto.contains(purchasedLottoNumber)) {
                sameCmt++;
            }
        }
        return sameCmt;
    }

    public int getSameCmt() {
        return sameCmt;
    }

    public int getBonusCorrect() {
        return bonusCorrect;
    }
}
