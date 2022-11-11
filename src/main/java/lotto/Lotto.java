package lotto;

import exception.LottoExceptionType;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private final int NUM_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionType.NOT_MATCH_CNT.getErrorMessage());
        }
    }

    public void validateRange(List<Integer> numbers){
        for(int num : numbers){
            if(num < 1 || num > 45){
                throw new IllegalArgumentException(LottoExceptionType.NOT_MATCH_RANGE.getErrorMessage());
            }
        }
    }

    public void validateDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);

        if(set.size() != NUM_SIZE){
            throw new IllegalArgumentException(LottoExceptionType.NOT_UNIQUE_NUMBER.getErrorMessage());
        }
    }

    public List<Integer> numbersAscending(List<Integer> numbers){
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);

        return numbers;
    }

    // TODO: 추가 기능 구현
}
