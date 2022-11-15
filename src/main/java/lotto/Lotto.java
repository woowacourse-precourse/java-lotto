package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6���� ���ڰ� �ƴմϴ�.");
        }

        HashSet<Integer> set = new HashSet<>(numbers);

        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] �ߺ��� ���ڰ� �����ϴ�.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
