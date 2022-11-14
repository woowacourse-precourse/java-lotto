package lotto.domain.lotto;

import lotto.resource.message.ErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateLottoNumberCount(numbers);

        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_IS_NOT_SIX.getValue());
        }
    }

    public int getMaxNum() {
        return numbers.stream().reduce(Math::max).orElse(-1);
    }

    public int getMinNum() {
        return numbers.stream().reduce(Math::min).orElse(-1);
    }

    public int getCount() {
        return numbers.size();
    }
}
