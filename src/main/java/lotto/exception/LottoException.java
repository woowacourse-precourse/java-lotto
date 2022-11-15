package lotto.exception;

import java.util.List;

public class LottoException {
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또의 6개의 수는 중복될 수 없습니다.";

    public static void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    public static void isValidNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }

    public static void isDuplicateNumber(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }
}
