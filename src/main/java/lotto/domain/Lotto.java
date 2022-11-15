package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBERS=1;
    public static final int MAX_LOTTO_NUMBERS=45;
    public static final int LOTTO_SIZE=6;
    public static final int LOTTO_PRICE=1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.print());
        }
    }

    private void validateRange(List<Integer> numbers) throws IllegalArgumentException{
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)<MIN_LOTTO_NUMBERS || numbers.get(i)>MAX_LOTTO_NUMBERS){
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
