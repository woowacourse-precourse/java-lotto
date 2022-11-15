package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constValue.Constants.ExceptionMessage.*;
import static lotto.constValue.Constants.LottoInfo.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedLottoNumber(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            throwOverRangeException(number);
        }
    }

    private static void throwOverRangeException(Integer number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedLottoNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumber = getNonDuplicatedNumber(numbers);
        if (numbers.size() == nonDuplicatedNumber.size()) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    private static Set<Integer> getNonDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumber = new HashSet<>();
        for (Integer number : numbers) {
            nonDuplicatedNumber.add(number);
        }
        return nonDuplicatedNumber;
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
