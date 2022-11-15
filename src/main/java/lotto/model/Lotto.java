package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }

        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("로또의 숫자들은 중복될 수 없습니다.");
            }
        }
    }

    private void sortNumbers() {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
