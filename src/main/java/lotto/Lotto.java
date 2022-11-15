package lotto;


import java.util.HashSet;
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

        HashSet<Integer> duplicate = new HashSet<>();

        numbers.forEach(number->{
            if(duplicate.contains(number)){
                throw new IllegalArgumentException();
            }
            duplicate.add(number);
        });

    }

}
