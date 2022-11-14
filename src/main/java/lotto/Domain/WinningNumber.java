package lotto.Domain;

import java.util.List;

public class WinningNumber {

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> winningNumbers;

    int bonusNum;

    public WinningNumber(List<Integer> numbers) {
        validateWinningNum(numbers);
        this.winningNumbers = numbers;
    }

    private void validateWinningNum(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (!Validator.checkIsValidLottoNum(numbers)) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_NUMS);
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }


}
