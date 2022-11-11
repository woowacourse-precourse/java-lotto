package lotto.model;

import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.LottoExceptionMessage;

public class Lotto {
    public static final int PRICE = 1000;
    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers.stream().collect(Collectors.toSet());
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
