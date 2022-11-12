package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasSameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void hasSameNumber(List<Integer> numbers) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        tmpNumbers.sort(Comparator.naturalOrder());
        for (int index = 1; index < tmpNumbers.size(); index++) {
            if (tmpNumbers.get(index) == tmpNumbers.get(index-1)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
