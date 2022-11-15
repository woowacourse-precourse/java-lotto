package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> duplicateCheckSet = new HashSet<>(numbers);
        if(duplicateCheckSet.size()!= numbers.size()){
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현

    public void printNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }
}
