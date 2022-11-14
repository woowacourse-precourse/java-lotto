package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.AdditionalFunction.validateNumRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 되어야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumRange(num);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberDistinct = new HashSet<>(numbers);
        if (numberDistinct.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
