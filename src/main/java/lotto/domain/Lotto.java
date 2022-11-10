package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static lotto.LottoExceptions.createLottoException;

public class Lotto {
    public static final int NUMBER_COUNT = 6;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public int get(int index) {
        return numbers.get(index);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw createLottoException("로또번호는 6개여야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw createLottoException("로또번호는 중복되면 안됩니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(
                number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw createLottoException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public MatchAndReward match(Lotto other) {
        int matchCount = (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();

        return MatchAndReward.getByMatch(matchCount);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        numbers.stream()
                .map(number -> number + "")
                .forEach(joiner::add);

        return joiner.toString();
    }
}
