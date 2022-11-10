package lotto.domain;

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

    public int getWinningAmount(int rank) {
        if(rank == Constant.FIVE) {
            return Constant.FIFTH_WINNING_AMOUNT;
        }
        if(rank == Constant.FOUR) {
            return Constant.FOURTH_WINNING_AMOUNT;
        }
        if(rank == Constant.THREE) {
            return Constant.THIRD_WINNING_AMOUNT;
        }
        if(rank == Constant.TWO) {
            return Constant.SECOND_WINNING_AMOUNT;
        }
        if(rank == Constant.ONE) {
            return Constant.FIRST_WINNING_AMOUNT;
        }
        return Constant.ZERO;
    }
}
