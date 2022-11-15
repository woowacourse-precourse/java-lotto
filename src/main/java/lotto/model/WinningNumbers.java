package lotto.model;

import lotto.utils.ErrorMessage;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber){
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
    private void validate(List<Integer> winningNumbers,Integer bonusNumber){
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.WINNINGNUMBER_CONTAINS_BONUSNUMBER.message);
        }
    }
}
