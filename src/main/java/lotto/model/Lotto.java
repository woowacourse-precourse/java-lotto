package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Env;
import lotto.util.Lang;
import lotto.util.Validator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public static Lotto from(String input) {
        input = input.trim();
        List<String> raw = List.of(input.split(","));

        return new Lotto(parseIntList(raw));
    }

    private static List<Integer> parseIntList(List<String> original) {
        try {
            return original
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Lang.THROW_NON_NUMERIC_CHARACTER);
        }
    }

    public static Lotto fromRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Env.LOTTO_FIRST_NUMBER,
                Env.LOTTO_LAST_NUMBER,
                Env.LOTTO_NUMBERS
        );

        return new Lotto(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.validate(numbers);
        this.numbers = this.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        this.validateCorrectLottoNumberSize(numbers);
        this.validateCorrectLottoNumberDeduplicateSize(numbers);
        this.validateCorrectRangeNumbers(numbers);
    }

    private void validateCorrectLottoNumberSize(List<Integer> numbers) {
        if (Validator.isNotCorrectLottoNumberSize(numbers, false)) {
            throw new IllegalArgumentException(Lang.format(
                    Lang.THROW_ELEMENT_INSUFFICIENT,
                    Env.LOTTO_NUMBERS - 1,
                    Env.LOTTO_NUMBERS
            ));
        }
    }

    private void validateCorrectLottoNumberDeduplicateSize(List<Integer> numbers) {
        if (Validator.isNotCorrectLottoNumberSize(numbers, true)) {
            throw new IllegalArgumentException(Lang.format(
                    Lang.THROW_ELEMENT_DUPLICATE,
                    Env.LOTTO_NUMBERS
            ));
        }
    }

    private void validateCorrectRangeNumbers(List<Integer> numbers) {
        if (Validator.hasNotCorrectRangeNumbers(numbers)) {
            throw new IllegalArgumentException(Lang.format(
                    Lang.THROW_OUT_RANGE,
                    Env.LOTTO_FIRST_NUMBER,
                    Env.LOTTO_LAST_NUMBER
            ));
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> retainAll(Lotto lotto) {
        List<Integer> numbers = new LinkedList<>(this.numbers);
        numbers.retainAll(lotto.toList());

        return numbers;
    }

    private List<Integer> toList() {
        return Collections.unmodifiableList(this.numbers);
    }

    public boolean contains(Bonus bonus) {
        return this.numbers.contains(bonus.toInt());
    }

    @Override
    public String toString() {
        String build = this.numbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", build);
    }
}
