package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        checkDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현

    public void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()) {
            new Exceptions("중복된 숫자가 없어야 한다");
        }
    }
    public List<Integer> returnNumbers(){
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
