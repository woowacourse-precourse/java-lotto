package lotto.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALIDATE_NUMBER_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개만 가능합니다.";
    private static final String INVALIDATE_DUPLICATION_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALIDATE_NUMBER_SIZE_MESSAGE);
        }
    }
    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicationNumbers = new HashSet<>(numbers);

        if (nonDuplicationNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALIDATE_DUPLICATION_MESSAGE);
        }
    }

    public List<Integer> setLotto() {
        return numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
