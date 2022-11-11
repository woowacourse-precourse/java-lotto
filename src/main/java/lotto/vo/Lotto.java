package lotto.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final static int LOTTO_FIRST_NUMBER = 1;
    private final static int LOTTO_LAST_NUMBER = 45;
    private final static int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = sortNumbers(numbers);
        this.validate();
    }

    @Override
    public String toString() {
        String joinWithComma = this.numbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", joinWithComma);
    }

    private void validate() {
        if (this.isNotNumbersSizeSameAs(LOTTO_NUMBERS_SIZE, false)) {
            throw new IllegalArgumentException("6개 번호를 입력해주세요.");
        }

        if (this.isNotNumbersSizeSameAs(LOTTO_NUMBERS_SIZE, true)) {
            throw new IllegalArgumentException("중복된 번호가 없도록 입력해주세요.");
        }

        if (this.hasNotCorrectRangeNumbers(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)) {
            throw new IllegalArgumentException("번호는 1부터 45까지 입력해주세요.");
        }
    }

    private boolean isNotNumbersSizeSameAs(int size, boolean deduplicate) {
        List<Integer> numbers = new LinkedList<>(this.numbers);

        if (deduplicate) {
            numbers = numbers
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
        }

        return (numbers.size() != size);
    }

    private boolean hasNotCorrectRangeNumbers(int first, int last) {
        return !this.numbers
                .stream()
                .allMatch(number -> (number >= first && number <= last));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
