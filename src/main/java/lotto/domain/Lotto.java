package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isInBound(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 잘못되었습니다.");
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean isInBound(List<Integer> numbers) {
        return numbers.size() == Config.LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != Config.LOTTO_NUMBER_COUNT;
    }
}
