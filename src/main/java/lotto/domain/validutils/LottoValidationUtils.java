package lotto.domain.validutils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidationUtils {

    public static final String ERROR_NOT_VALID_NUMBER_SIZE = "[ERROR] 로또 번호의 개수는 6개 이어야 합니다.";
    public static final String ERROR_NOT_VALID_NUMBER_DUPLICATION = "[ERROR] 로또 번호에는 중복 된 숫자가 없어야합니다.";
    public static final String ANSWER_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 정답 번호와 중복되면 안됩니다.";

    public static final int CRITERION_LOTTO_SIZE = 6;

    private LottoValidationUtils() {
    }

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != CRITERION_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_NUMBER_SIZE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> removeDuplication = new HashSet<>(numbers);
        if (removeDuplication.size() != CRITERION_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_NUMBER_DUPLICATION);
        }
    }

    public static void validateDuplication(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ANSWER_DUPLICATE_BONUS_NUMBER);
        }
    }
}
