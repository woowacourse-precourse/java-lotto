package lotto.domain;

import java.util.List;

import lotto.utils.ErrorMessages;
import lotto.utils.LottoInfo;
import lotto.utils.Validator;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countWinning(List<Integer> lottoNumbers) {
        int count = 0;

        for (int lottoNumber : lottoNumbers) {
            count += getCountForPlus(lottoNumber);
        }

        return count;
    }

    public void checkBonusNumber(int bonusNumberInput) {
        if (numbers.contains(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        Validator.containDuplicate(numbers);
        Validator.listLengthCheck(numbers, LottoInfo.LENGTH.getNumber());
        for (int number : numbers) {
            Validator.isInRange(number);
        }
    }

    private int getCountForPlus(int lottoNumber) {
        if (numbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
