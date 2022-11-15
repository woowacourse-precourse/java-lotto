package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NECESSARY_LOTTO_COUNT = 6;
    private static final String INVALID_LOTTO_COUNT = "[ERROR] 로또 티켓은 중복되지 않은 6자리 숫자로 구성되어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (numbers.size() != NECESSARY_LOTTO_COUNT || numbers.size() != count) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT);
        }
    }

    public int checkMatchCounts(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
