package lotto.domain;

import lotto.domain.enums.Number;
import lotto.util.ExceptionHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    LottoMachine lottoMachine = new LottoMachine();

    public void setWinningNumbers(String input) {
        String[] numbers = input.split(ExceptionHandler.COMMA);
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public void setBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> changeLottos(double money) {
        List<Lotto> lottos = new ArrayList<>();
        int totalCount = (int)money % 1000;

        for (int repeat = 1; repeat <= totalCount; repeat++) {
            Lotto lotto = lottoMachine.generateLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    public int getCorrectCount(List<Integer> userLotto) {
        int correctCount = 0;

        for (int index = 0; index < Number.LOTTO_SIZE.getValue(); index++) {
            if (winningNumbers.contains(userLotto.get(index)) || bonusNumber == userLotto.get(index)) {
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
