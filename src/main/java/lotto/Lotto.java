package lotto;

import domain.ConstantNumber;

import java.util.List;

import static domain.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumber(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateLottoNumber(List<Integer> numbers){
        isDistinctNumber(numbers);
        isLottoSize(numbers);
        for (Integer number : numbers) {
            isLottoRange(number);
        }
    }

    private void isLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void isDistinctNumber(List<Integer> lottoNumber) {
        if(lottoNumber.stream().distinct().count() != lottoNumber.size()){
            throw new IllegalArgumentException(NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());
        }
    }

    private void isLottoRange(int number){
        if(number < ConstantNumber.MIN_LOTTO_NUMBER.getNumber()
                || number > ConstantNumber.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NOT_LOTTO_RANGE_ERROR.getMessage());
        }
    }
}
