package lotto.numbers;

import lotto.constants.LottoConstants;

import java.util.List;

import static lotto.constants.ExceptionMessage.*;

public class Lotto implements LottoInterface{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    //유효성 검사
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        for(Integer num : numbers) {
            validateRange(num);
        }
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        long numberOfUniqueNumbers = numbers.stream().distinct().count();
        if(numberOfUniqueNumbers != LottoConstants.NUMBER_OF_PICKED) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS_IN_LOTTO);
        }
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_OF_PICKED) {
            throw new IllegalArgumentException(INAPPROPRIATE_SIZE_LOTTO_NUMBER);
        }
    }

    protected void validateRange(int num) {
        if(num < LottoConstants.START_NUMBER_OF_LOTTO || num > LottoConstants.END_NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(INAPPROPRIATE_RANGE_OF_LOTTO_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        if(numbers == null) {
            throw new IllegalArgumentException(NO_LOTTO_NUMBERS);
        }
        return numbers;
    }
}
