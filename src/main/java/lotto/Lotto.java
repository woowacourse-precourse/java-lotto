package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }d

    public Integer countMatched(List<Integer> winningNumbers){
        Integer number = 0;
        for (Integer winningNumber : winningNumbers){
               if (numbers.contains(winningNumber)) number += 1;
        }
        return number;
    }

    public Boolean contains(Integer bonus){
        return numbers.contains(bonus);
    }


}
