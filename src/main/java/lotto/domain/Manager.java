package lotto.domain;

import lotto.domain.enums.Number;
import lotto.util.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

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

    public int countCorrect(Lotto userLotto) {
        List<Integer> lottoNumbers = userLotto.getNumbers();

        int correctCount = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            Integer userLottoNumber = lottoNumbers.get(i);
            if (isCorrectNumber(userLottoNumber)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    private boolean isCorrectNumber(Integer userLottoNumber) {
        return winningNumbers.contains(userLottoNumber);
    }

    public boolean isCorrectBonus(Lotto userLotto) {
        List<Integer> numbers = userLotto.getNumbers();
        return numbers.contains(bonusNumber);
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
