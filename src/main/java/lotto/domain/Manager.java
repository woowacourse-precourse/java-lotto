package lotto.domain;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void setWinningNumbers(String input) {
        String[] numbers = input.split(InputUtil.COMMA);
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int changeLottoCount(int money) {
        InputUtil.checkValidationMoney(String.valueOf(money));

        if (money >= 0) {
            return (money / 1000);
        }

        throw InputUtil.makeIllegalArgumentException(Message.MINUS_INPUT_ERROR.getMessage());
    }

    public int getCorrectCount(List<Integer> userLotto) {
        int correctCount = 0;

        Collections.sort(winningNumbers);
        Collections.sort(userLotto);

        for (int i = 0; i < Number.LOTTO_SIZE.getValue(); i++) {
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
        if (!isCorrectBonus && correctCount == Number.FIVE.getValue()) {
            return Number.THREE.getValue();
        }
        if (isCorrectBonus && correctCount == Number.FIVE.getValue()) {
            return Number.TWO.getValue();
        }
        if (correctCount == Number.SIX.getValue()) {
            return Number.ONE.getValue();
        }
        return Number.ZERO.getValue();
    }

    public int getWinningAmount(int rank) {
        if(rank == Number.FIVE.getValue()) {
            return Number.FIFTH_WINNING_AMOUNT.getValue();
        }
        if(rank == Number.FOUR.getValue()) {
            return Number.FOURTH_WINNING_AMOUNT.getValue();
        }
        if(rank == Number.THREE.getValue()) {
            return Number.THIRD_WINNING_AMOUNT.getValue();
        }
        if(rank == Number.TWO.getValue()) {
            return Number.SECOND_WINNING_AMOUNT.getValue();
        }
        if(rank == Number.ONE.getValue()) {
            return Number.FIRST_WINNING_AMOUNT.getValue();
        }
        return Number.ZERO.getValue();
    }
}
