package model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateInputLottoNumbers(numbers);
        validateInputLottoNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateInputLottoNumbers(List<Integer> numbers) {
        int lottoNumbersCount = getLottoNumbersSet(numbers).size();

        if (lottoNumbersCount != 6) {
            throw new IllegalArgumentException(Errors.DUPLICATE_LOTTO_NUMBER.getErrorMsg());
        }
    }

    private void validateInputLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Errors.NUMBER_RANGE.getErrorMsg());
            }
        }
    }

    private HashSet<Integer> getLottoNumbersSet(List<Integer> numbers) {
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);

        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
