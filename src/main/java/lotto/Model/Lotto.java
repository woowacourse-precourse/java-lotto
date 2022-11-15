package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 제외한 로또 번호는 6개를 입력해야 합니다.");
        }
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
            }
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}