package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.Constant;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_INVALID_LOTTO_SIZE = "[ERROR] 6개의 숫자를 입력해 주세요.";
    private static final String ERROR_DUPLICATED_NUMBERS = "[ERROR] 서로 다른 숫자를 입력해 주세요.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        validateRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        if (isDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_NUMBERS);
        }
    }

    private boolean isDuplicated(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();
    }

    private void validateRange(List<Integer> lottoNumbers) {
        if (isOutOfRange(lottoNumbers)) {
            throw new IllegalArgumentException(Constant.ERROR_OUT_OF_RANGE_NUMBER);
        }
    }

    private boolean isOutOfRange(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(number -> (number >= Constant.MIN_NUMBER && number <= Constant.MAX_NUMBER))
                .count() != lottoNumbers.size();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}