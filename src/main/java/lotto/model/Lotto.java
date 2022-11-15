package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Constant.LOTTO_END;
import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.LOTTO_START;

public class Lotto {
    public static final String ERROR_GENERATED_DIFFERENT_LOTTO_SIZE = "[ERROR] 생성된 로또 번호의 개수가 다릅니다.";
    public static final String ERROR_GENERATED_DUPLICATED_LOTTO_NUMBERS = "[ERROR] 중복된 로또 번호가 생성 되었습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (isDifferentSize(numbers)) {
            throw new IllegalArgumentException(ERROR_GENERATED_DIFFERENT_LOTTO_SIZE);
        }
    }

    private static boolean isDifferentSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (hasDuplicateNumbers(uniqueNumbers)) {
            throw new IllegalArgumentException(ERROR_GENERATED_DUPLICATED_LOTTO_NUMBERS);
        }
    }

    private static boolean hasDuplicateNumbers(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    public static Lotto create() {
        List<Integer> lottoNumbers = pickUniqueRandomNumbers();
        return new Lotto(lottoNumbers);
    }

    protected static List<Integer> pickUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_SIZE);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
