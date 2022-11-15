package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValid(numbers);
        duplicatedValid(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMsg.SIZE_UP_MSG.getErrorMsg());
        }
    }

    private void rangeValid(List<Integer> numbers){
        numbers.forEach(number -> {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException(ErrorMsg.NUM_RANGE_MSG.getErrorMsg());
            }
        });
    }

    private void duplicatedValid(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMsg.NUM_CONTAIN_MSG.getErrorMsg());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
