package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
       validateNumberCounts(numbers);
       validateDuplicate(numbers);
       validateRange(numbers);
    }

    void validateNumberCounts(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_ERROR.getMessage());
        }
    }

    void validateDuplicate(List<Integer> numbers){
        for(int i : numbers){
            if(this.numbers.contains(i)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.getMessage());
            }
            this.numbers.add(i);
        }
        Collections.sort(this.numbers);
    }

    void validateRange(List<Integer> numbers){
        for(int i : numbers){
            if(i <1 | i>45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    public List<Integer> getLotto(){
        return this.numbers;
    }
}
