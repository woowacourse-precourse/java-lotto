package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValid(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void rangeValid(List<Integer> numbers){
        numbers.forEach(number -> {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException();
            }
        });
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
