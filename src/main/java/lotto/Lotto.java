package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        try{
            Collections.sort(numbers);
        }catch (UnsupportedOperationException e){
            List<Integer> modifiableNumbers = new ArrayList<Integer>(numbers);
            Collections.sort(modifiableNumbers);
            return modifiableNumbers;
        }
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
