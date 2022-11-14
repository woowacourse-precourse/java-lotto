package lotto.domain;

import lotto.utils.validator.LottoValidator;

import java.util.List;

public class Answer {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        winningNumbersValidate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void winningNumbersValidate(List<Integer> numbers) {
        Lotto.validate(numbers);
    }

    private void bonusNumberValidate(int number) {
        LottoValidator.checkLottoNumber(number);
        LottoValidator.checkContainNumber(winningNumbers, number);
    }
}
