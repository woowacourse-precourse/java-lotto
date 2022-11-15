package lotto;

import java.util.List;
import view.Message;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        checkNumberRange(numbers);
        checkNumberOverLap(numbers);
        this.numbers = numbers;
    }

    private void checkNumberRange(List<Integer> numbers)  {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
            }
    }

    private void checkNumberOverLap(List<Integer>numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Message.ERROR_NUMBER_OVERLAP.getMessage());
        }
    }


}