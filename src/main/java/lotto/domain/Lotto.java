package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBERS_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6자리의 숫자여야 합니다.";
    private static final String LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 중복되어선 안됩니다.";
    private static final String LOTTO_NUMBERS_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoSizeExceptionCheck(numbers);
        lottoNumbersDuplicateExceptionCheck(numbers);
        lottoNumbersRangeExceptionCheck(numbers);
        List<Integer> lotto = new ArrayList<>(numbers);
        Collections.sort(lotto);
        this.numbers = lotto;
    }

    private void lottoNumbersRangeExceptionCheck(List<Integer> numbers) {
        boolean winningLottoNumbersRangeCheckResult = winningLottoNumbersRangeCheck(numbers);
        if (!winningLottoNumbersRangeCheckResult) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean winningLottoNumbersRangeCheck(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(i -> (i >= LOTTO_NUMBER_MIN && i <= LOTTO_NUMBER_MAX));
    }

    private void lottoNumbersDuplicateExceptionCheck(List<Integer> numbers) {
        int duplicateCheckSize = getDuplicateCheckSize(numbers);
        if (duplicateCheckSize != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private int getDuplicateCheckSize(List<Integer> numbers) {
        return new HashSet<>(numbers)
                .size();
    }

    private void lottoSizeExceptionCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }
    }
}
