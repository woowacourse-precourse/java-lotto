package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Env;
import lotto.Validator;

import java.util.Collections;
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
            throw new IllegalArgumentException("입력한 내용 중 숫자가 아닌 문자가 있어요.");
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
        if (Validator.isNotCorrectLottoNumberSize(numbers, false)) {
            throw new IllegalArgumentException("5개 이하의 숫자를 입력했어요. 6개 숫자를 입력해 주세요.");
        }

        if (Validator.isNotCorrectLottoNumberSize(numbers, true)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했어요. 중복 없는 6개 숫자를 입력해 주세요.");
        }

        if (Validator.hasNotCorrectRangeNumbers(numbers)) {
            throw new IllegalArgumentException("1 ~ 45 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(this.numbers);
    }

    public boolean equals(Lotto lotto) {
        return this.numbers.equals(lotto.toList());
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
