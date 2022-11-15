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
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_DUPLICATED_NUM_EXCEPTION.getMessage());
    }

    public Integer scoreLottoNumbers(List<Integer> winningNumber, Integer bonus){
        Integer correct = 0;
        for(Integer num : numbers){
            if(winningNumber.contains(num)) correct ++;
        }
        if(correct == 6) return 1;
        if(correct ==5){
            if(numbers.contains(bonus)) return 2;
            return 3;
        }
        if(correct == 4) return 4;
        if(correct == 3) return 5;
        return 0;
    }

}
