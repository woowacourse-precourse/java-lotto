package lotto.Model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size()!=6){
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_RANGE));
            }
        }
    }

    private void validateDuplication(List<Integer> numbers){
        int[] count = new int[45];
        for(Integer number: numbers) {
            count[number]++;
            if(count[number]>1){
                throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_UNIQUE_NUMBER));
            }
        }
    }
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    // TODO: 추가 기능 구현
}
