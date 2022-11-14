package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.domain.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkDuplicate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Set<Integer> sort = new TreeSet<>(numbers);
        return new ArrayList<>(sort);
    }
}
