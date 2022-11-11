package lotto;

import exception.LottoExceptionType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final int NUM_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionType.NOT_MATCH_CNT.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int num : numbers){
            if(num < 1 || num > 45){
                throw new IllegalArgumentException(LottoExceptionType.NOT_MATCH_RANGE.getErrorMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);

        if(set.size() != NUM_SIZE){
            throw new IllegalArgumentException(LottoExceptionType.NOT_UNIQUE_NUMBER.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
}
