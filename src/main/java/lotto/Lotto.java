package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRangeOfNumbers(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeOfNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        for (int num : numbers) {
            List<Integer> numSublist = numbers.subList(numbers.indexOf(num)+1, 6);
            if (numSublist.contains(num)) {
                throw new IllegalArgumentException();
            }
        }
    }



    public void printLotto() {
        System.out.println(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
