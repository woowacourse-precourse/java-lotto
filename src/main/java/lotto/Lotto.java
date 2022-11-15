package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

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
    }

    private void DuplicateNumber(List<Integer> numbers){

        }
    }

    public void NumberRange(List<Integer> numbers){
        
    }
}

