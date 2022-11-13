package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;

public class Lotto {
    protected static final String DUPLICATED_NUMBER = "중복된 당첨 번호가 존재합니다.";
    
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", getSortedNumbers());
    }

    private List<String> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
