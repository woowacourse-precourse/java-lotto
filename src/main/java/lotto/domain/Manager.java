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
        if (correctCount == Number.THREE.getValue()) {
            return Number.FIVE.getValue();
        }
        if (correctCount == Number.FOUR.getValue()) {
            return Number.FOUR.getValue();
        }
        if (correctCount == Number.FIVE.getValue()) {
            return Number.THREE.getValue();
        }
        if (correctCount == Number.FIVE.getValue() && isCorrectBonus) {
            return Number.TWO.getValue();
        }
        if (correctCount == Number.SIX.getValue()) {
            return Number.ONE.getValue();
        }
        return Number.ZERO.getValue();
    }

    public int getWinningAmount(int rank) {
        if(rank == Number.FIVE.getValue()) {
            return Constant.FIFTH_WINNING_AMOUNT;
        }
        if(rank == Number.FOUR.getValue()) {
            return Constant.FOURTH_WINNING_AMOUNT;
        }
        if(rank == Number.THREE.getValue()) {
            return Constant.THIRD_WINNING_AMOUNT;
        }
        if(rank == Number.TWO.getValue()) {
            return Constant.SECOND_WINNING_AMOUNT;
        }
        if(rank == Number.ONE.getValue()) {
            return Constant.FIRST_WINNING_AMOUNT;
        }
        return Number.ZERO.getValue();
    }
}
