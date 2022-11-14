package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.print());
        }
    }

    private void validateRange(List<Integer> numbers) throws IllegalArgumentException{
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.print());
            }
        }
    }
    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        for(int i=0; i< numbers.size(); i++){
            if(Collections.frequency(numbers, numbers.get(i))>1){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.print());
            }
        }
    }
    public List<Integer> getLotto(){ return numbers;}
}
