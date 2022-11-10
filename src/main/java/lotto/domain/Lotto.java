package lotto.domain;

import java.util.List;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = deDuplicationAndSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자만 허용됩니다.");
        }
    }

    private List<Integer> deDuplicationAndSort(List<Integer> numbers) {
        if (deDuplicationAndSort(numbers).size() != 6) {
            throw new IllegalArgumentException("[Error] 로또 번호는 중복이 허용되지 않습니다.");
        }
        return List.copyOf(new TreeSet<Integer>(numbers));
    }

    public List<Integer> get() {
        return numbers;
    }
}
