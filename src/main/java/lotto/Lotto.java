package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberChecker = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        } else if(numbers.size() != numberChecker.size()){
            throw new IllegalArgumentException();
        }
    }

    public void printLotto(){
        System.out.println(numbers);
    }
}
