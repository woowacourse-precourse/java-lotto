package lotto;

import java.util.List;
import view.Message;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        checkNumberSize(numbers);
        checkNumberOverLap(numbers);
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    private void checkNumberSize(List<Integer> numbers)  {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(Message.ERRROR_LOTTO_SIZE.getMessage());
            }
    }

    private void checkNumberOverLap(List<Integer>numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Message.ERROR_NUMBER_OVERLAP.getMessage());
        }
    }

    private void checkNumberRange(List<Integer>numbers){
        for(int i=0;i<numbers.size();i++){
            if(!(numbers.get(i)>=1&&numbers.get(i)<=45)){
                throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
            }
        }
    }


}