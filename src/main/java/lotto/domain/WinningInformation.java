package lotto.domain;

import lotto.validator.ValidationInDomain;

import java.util.List;

public class WinningInformation {
    private final ValidationInDomain validator = new ValidationInDomain();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningInformation(List<Integer> winningNumbers, int bonusNumber){
        setWinningNumbers(winningNumbers);
        setBonusNumber(bonusNumber);
    }
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void setWinningNumbers(List<Integer> winningNumbers) {
        validator.checkNumberOfNumbers(winningNumbers);
        validator.checkNumbersDuplication(winningNumbers);
        for(int winningNumber : winningNumbers){
            validator.checkNumberRange(winningNumber);
        }
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(int bonusNumber) {
        validator.checkNumberRange(bonusNumber);
        validator.checkBonusNumberDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
