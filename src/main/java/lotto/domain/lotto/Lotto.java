package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
