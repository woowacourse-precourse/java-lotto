package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MainNumber {
    private final List<Integer> numbers;

    public MainNumber(String userInput) {
        List<Integer> numbers = validate(userInput);
        this.numbers = numbers;
    }

    private List<Integer> validate(String userInput) {
        String[] elements = Validator.inputFormatCheck(userInput);
        List<Integer> numbers = toInts(elements);
        Validator.duplicationCheck(numbers);
        Validator.rangeCheck(numbers);
        return numbers;
    }

    private List<Integer> toInts(String[] elements) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : elements) {
            Validator.numberFormatCheck(element);
            numbers.add(Integer.parseInt(element));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
