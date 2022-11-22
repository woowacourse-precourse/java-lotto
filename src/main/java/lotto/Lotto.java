package lotto;

import domain.ConstantNumber;
import domain.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumber(numbers);
    }

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
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void isDistinctNumber(List<Integer> lottoNumber) {
        if(lottoNumber.stream().distinct().count() != lottoNumber.size()){
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());
        }
    }

    private void isLottoRange(int number){
        if(number < ConstantNumber.MIN_LOTTO_NUMBER.getNumber()
                || number > ConstantNumber.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_RANGE_ERROR.getMessage());
        }
    }
}
