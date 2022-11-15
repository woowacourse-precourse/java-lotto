package domain;


import view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

import static controller.Util.validateDuplicate;
import static controller.Util.validateSize;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
