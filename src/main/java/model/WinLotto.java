package model;

import static model.Lotto.LOTTO_SIZE;
import static model.Lotto.hasDuplicateNum;
import static model.Lotto.isNumRangeLotto;

import java.util.ArrayList;
import java.util.List;
import util.message.ErrorMessage;

public class WinLotto  {
    private int bonusNumber;
    private final List<Integer> numbers;

    public WinLotto(List<Integer> numbers,int bonusNumber) {
        validate(numbers,bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        List<Integer> numbersForValid = getNumbersForValid(numbers, bonusNumber);
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_LENGTH_SIZE_NOT_SIX);
        }
        if (hasDuplicateNum(numbersForValid)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
        }
        if (!isNumRangeLotto(numbersForValid)) {
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
