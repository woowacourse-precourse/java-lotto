package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            validate(numbers);
            duplicateNumCheck(numbers);
            inRange(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

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

    private void duplicateNumCheck(List<Integer> numbers) {
        for(int i = 0; i<numbers.size(); i++) {
            int tmp = numbers.get(i);
            lowerNumCheck(numbers, i, tmp);
        }
    }

    private void lowerNumCheck(List<Integer> numbers, int i, int tmp) {
        for(int j = i+1; j<numbers.size(); j++) {
            if(tmp == numbers.get(j)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void inRange(List<Integer> numbers) {
        for(int j = 0; j<numbers.size(); j++) {
            if((1 > numbers.get(j) || numbers.get(j) > 45)){
                throw new IllegalArgumentException();
            }
        }
    }
}
