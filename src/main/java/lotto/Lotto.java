package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 6개의 숫자로 구성되어야 합니다..");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 서러 다른 수이어야 합니다.");
        }
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Comparator.comparingInt(o -> o));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
