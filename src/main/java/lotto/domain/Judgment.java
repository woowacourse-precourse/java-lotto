package lotto.domain;

import java.util.List;

class Judgment {
    List<Integer> winNumbers;
    private int bonusNum;

    Judgment(List<Integer> winNumbers, int bonusNum) {
        this.winNumbers = winNumbers;
        this.bonusNum = bonusNum;
    }

    int countCorrect(Lotto lotto) {
        int result = 0;
        for (int num : lotto.getNumbers()) {
            if (winNumbers.contains(num)) {
                result++;
            }
        }
        return result;
    }

    boolean checkBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNum);
    }
}
