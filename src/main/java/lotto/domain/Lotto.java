package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int lottoSize = 6;
    private final int lottoNumStart = 1;
    private final int lottoNumEnd = 45;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        validateOverLap(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    // List 크기가 6개인지 검증
    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    // 로또 번호가 중복되는지 검증
    private void validateOverLap(List<Integer> numbers) throws IllegalArgumentException{
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() != lottoSize) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

    // 로또 번호가 범위 내에 있는지 검증
    private void validateRange(List<Integer> numbers) throws IllegalArgumentException{
        for(int num : numbers) {
            if (!(num >= lottoNumStart && num <= lottoNumEnd)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
