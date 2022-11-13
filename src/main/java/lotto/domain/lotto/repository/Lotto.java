package lotto.domain.lotto.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.constant.enumtype.UserInterfaceMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (numbers.size() != LottoRule.LOTTO_MAX_COUNT.getValue() || lottoNumbers.size() != LottoRule.LOTTO_MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.REQUEST_INPUT_PRICE_INFO.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
