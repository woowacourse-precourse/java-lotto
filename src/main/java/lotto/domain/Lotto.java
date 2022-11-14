package lotto.domain;

import lotto.setting.Setting;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    // 당첨 번호 반환
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // 6개의 숫자인지 검증하는 기능
    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Setting.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개 숫자를 입력해야 합니다.");
        }
    }

    // 중복된 숫자가 있는지 검증하는 기능
    private void validateDuplication(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> deduplication = new HashSet<>(numbers);
        if (deduplication.size() != Setting.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    // 1 이상 45 이하의 숫자들인지 검증하는 기능
    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        long validNumber = numbers.stream()
                                    .filter(number -> number >= Setting.LOTTO_MIN_NUMBER)
                                    .filter(number -> number <= Setting.LOTTO_MAX_NUMBER)
                                    .count();
        if (validNumber != Setting.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 1이상 45이하의 숫자를 입력해야 합니다.");
        }
    }
}
