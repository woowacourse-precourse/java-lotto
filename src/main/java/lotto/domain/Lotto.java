package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> NUMBERS;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.NUMBERS = numbers;
    }

    public List<Integer> getLottoNumber() {
        return NUMBERS;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException("총 6개의 숫자를 입력해주세요.");
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException("로또 숫자는 1이상 45 이하의 숫자를 입력하셔야 합니다.");
        }
        if (!isValidUnique(numbers)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_LENGTH;
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                        .noneMatch(number -> number < START_LOTTO_NUMBER || END_LOTTO_NUMBER < number);
    }

    private boolean isValidUnique(List<Integer> numbers) {
        return numbers.stream()
                        .distinct()
                        .count() == LOTTO_NUMBERS_LENGTH;
    }
}
