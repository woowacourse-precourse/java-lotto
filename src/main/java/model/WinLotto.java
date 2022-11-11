package model;

import java.util.ArrayList;
import java.util.List;
import util.message.ErrorMessage;
import view.PrintView;

public class WinLotto extends Lotto {
    private int bonusNumber;

    public WinLotto(List<Integer> numbers,int bonusNumber) {
        validate(numbers,bonusNumber);
        sortAscend(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        List<Integer> numbersForValid = getNumbersForValid(numbers, bonusNumber);
        if (numbers.size() != 6) {
//            PrintView.error(ErrorMessage.LOTTO_LENGTH_SIZE_NOT_SIX);
            throw new IllegalArgumentException(ErrorMessage.LOTTO_LENGTH_SIZE_NOT_SIX);
        }
        if (hasDuplicateNum(numbersForValid)) {
//            PrintView.error(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
        }
        if (!isNumRangeLotto(numbersForValid)) {
//            PrintView.error(ErrorMessage.IS_NOT_LOTTO_RANGE_NUM);
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_RANGE_NUM);
        }
    }

    private List<Integer> getNumbersForValid(List<Integer> numbers, int bonusNumber) {
        List<Integer> forValidNumbers = new ArrayList<>(numbers);
        forValidNumbers.add(bonusNumber);
        return forValidNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
