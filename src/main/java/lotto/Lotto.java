package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicated(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicated(List<Integer> numbers){
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if(distinctNumbers.size() != numbers.size())
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
    }

}
