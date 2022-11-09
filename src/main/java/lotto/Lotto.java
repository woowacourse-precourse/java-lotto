package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int CRITERION_LOTTO_SIZE = 6;
    public static final String ERROR_NOT_VALID_NUMBER_SIZE = "[ERROR] 로또 번호의 개수는 6개 이어야 합니다.";
    public static final String ERROR_NOT_VALID_NUMBER_DUPLICATION = "[ERROR] 로또 번호에는 중복 된 숫자가 없어야합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CRITERION_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_NUMBER_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> removeDuplication = new HashSet<>(numbers);
        if (removeDuplication.size() != CRITERION_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_NUMBER_DUPLICATION);
        }
    }

}
