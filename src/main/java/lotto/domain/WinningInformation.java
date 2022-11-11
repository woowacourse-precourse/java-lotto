package lotto.domain;

import java.util.List;

public class WinningInformation {
    private ValidationInDomain validator = new ValidationInDomain();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        for(int i = 0; i < winningNumbers.size(); i++){
            validator.checkNumberRange(winningNumbers.get(i));
        }
        validator.checkDuplicatedNumber(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validator.checkNumberRange(bonusNumber);
        validator.checkBonusNumberDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
