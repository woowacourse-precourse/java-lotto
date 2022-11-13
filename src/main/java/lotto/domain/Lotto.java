package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkDuplicateNumber();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(){
        HashSet<Integer> set = new HashSet<>(12);
        for(Integer number : numbers){
            if(set.contains(number))
                throw new IllegalArgumentException();
            set.add(number);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
