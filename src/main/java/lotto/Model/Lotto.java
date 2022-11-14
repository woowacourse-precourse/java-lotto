package lotto.Model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberSet = new TreeSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1장의 로또에서 6개의 번호가 생성되지 않았습니다.");
        }
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1장의 로또에서 6개의 번호가 중복되지 않아야합니다.");
        }
        for (Integer number : numberSet) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또의 숫자는 1 ~ 45 사이의 숫자여야합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
