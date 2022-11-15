package lotto.gameSetting;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbersRangeCheck(numbers);
        numbersOverlapCheck(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> winNumber() {
        return numbers;
    }

    private void numbersRangeCheck(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++) {
            if (numbers.get(i)<1 || numbers.get(i)>45) {
                throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION.message());
            }
        }
    }

    private void numbersOverlapCheck(List<Integer> numbers) {
        HashSet<Integer> checkOverlap = new HashSet<>(numbers);
        
        if (numbers.size() != checkOverlap.size()) {
            throw new IllegalArgumentException(ExceptionMessage.OVERLAP_EXCEPTION.message());
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.SIZE_EXCEPTION.message());
        }   
    }
}
