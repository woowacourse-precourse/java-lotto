package lotto.domain;

import lotto.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.print());
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)>=1 && numbers.get(i)<=45){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.print());
            }
        }
    }
}
