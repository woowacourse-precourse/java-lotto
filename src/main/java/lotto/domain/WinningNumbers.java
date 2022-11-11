package lotto.domain;

import java.util.List;

import lotto.utils.Validator;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //TODO : refactoring indent -1
    public int countWinning(List<Integer> lottoNumbers) {
        int count = 0;

        for (int lottoNumber : lottoNumbers) {
            if (numbers.contains(lottoNumber)) {
                count += 1;
            }
        }

        return count;
    }

    private void validate(List<Integer> numbers) {
        Validator.containDuplicate(numbers);
        Validator.listLengthCheck(numbers, 6);
        for (int number : numbers) {
            Validator.isInRange(number);
        }
    }
}
