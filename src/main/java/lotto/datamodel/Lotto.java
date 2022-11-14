package lotto.datamodel;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        reduplication(numbers);
        range(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void reduplication(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void range(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < 1 || numbers.get(i) >= 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
