package lotto.domain;

import lotto.domain.enums.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

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
        if (correctCount == Number.THREE.ordinal()) {
            return Number.FIVE.ordinal();
        }
        if (correctCount == Number.FOUR.ordinal()) {
            return Number.FOUR.ordinal();
        }
        if (correctCount == Number.FIVE.ordinal()) {
            return Number.THREE.ordinal();
        }
        if (correctCount == Number.FIVE.ordinal() && isCorrectBonus) {
            return Number.TWO.ordinal();
        }
        if (correctCount == Number.SIX.ordinal()) {
            return Number.ONE.ordinal();
        }
        return Number.ZERO.ordinal();
    }

    public int getWinningAmount(int rank) {
        if(rank == Number.FIVE.ordinal()) {
            return Constant.FIFTH_WINNING_AMOUNT;
        }
        if(rank == Number.FOUR.ordinal()) {
            return Constant.FOURTH_WINNING_AMOUNT;
        }
        if(rank == Number.THREE.ordinal()) {
            return Constant.THIRD_WINNING_AMOUNT;
        }
        if(rank == Number.TWO.ordinal()) {
            return Constant.SECOND_WINNING_AMOUNT;
        }
        if(rank == Number.ONE.ordinal()) {
            return Constant.FIRST_WINNING_AMOUNT;
        }
        return Number.ZERO.ordinal();
    }
}
