package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoGenerator.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoGenerator.MINIMUM_LOTTO_NUMBER;
import static lotto.support.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.support.ErrorMessage.INVALID_NUMBER_COUNT_ERROR;
import static lotto.support.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
        validateLottoNumberCount(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberRange(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getSortedNumbers() {
        return String.join(", ", sortNumbers());
    }

    private List<String> sortNumbers() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
