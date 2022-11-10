package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public int changeLottoCount(int money) {
        // TODO: money가 1천원 단위인지 확인
        return (money / 1000);
    }

    public int getCorrectCount(List<Integer> userLotto) {
        int correctCount = 0;

        Collections.sort(winningNumbers);
        Collections.sort(userLotto);

        for (int i = 0; i < Constant.LOTTO_SIZE; i++) {
            if(winningNumbers.get(i) == userLotto.get(i)) {
                correctCount++;
            }
        }

        return correctCount;
    }

    public boolean isCorrectBonus(List<Integer> userLotto) {
        return userLotto.contains(this.bonusNumber);
    }

    public int judgeRank(int correctCount, boolean isCorrectBonus) {
        if (correctCount == Constant.THREE) {
            return Constant.FIVE;
        }
        if (correctCount == Constant.FOUR) {
            return Constant.FOUR;
        }
        if (correctCount == Constant.FIVE) {
            return Constant.THREE;
        }
        if (correctCount == Constant.FIVE && isCorrectBonus) {
            return Constant.TWO;
        }
        if (correctCount == Constant.SIX) {
            return Constant.ONE;
        }
        return Constant.ZERO;
    }
}
