package lotto;

import lotto.Enums.ErrorMessage;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.Lotto_LENGTH.getMessage());
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.Lotto_DUPLICATE.getMessage());
        }
        if(!checkRange(numbers)){
            throw new IllegalArgumentException(ErrorMessage.Lotto_RANGE.getMessage());
        }
    }

    private boolean checkRange(List<Integer> numbers){
        int minNum = 1;
        int maxNum = 45;

        for(int num:numbers){
            if(num<minNum) return false;
            if(num>maxNum) return false;
        }
        return true;
    }

}
