package lotto.UI;

import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;
    public WinningNumbers(String input) {
        List<Integer>numbers = convertInputToNumbers(input);
        this.numbers = new Lotto(numbers).getNumbers();
    }
    private List<Integer> convertInputToNumbers(String input) {
        Error error = new Error();
        List<Integer> result = new ArrayList<>();
        try {
            result = Arrays.stream(input.split(","))
                    .map(s->Integer.valueOf(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            error.outOfRange();
        }
        return result;
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

