package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_RANGE_SIZE = 6;
    private static final String ERROR_PREFIX_MASSAGE = "[ERROR] ";
    private static final String ERROR_SIZE_MASSAGE = "로또 번호는 6개입니다.";
    private static final String ERROR_RANGE_MASSAGE = "로또 번호는 1부터 45까지입니다.";
    private static final String ERROR_DUPLICATE_MASSAGE = "로또 번호에 중복된 숫자는 없습니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_RANGE_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX_MASSAGE + ERROR_SIZE_MASSAGE);
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber: lottoNumbers) {
            checkInRange(lottoNumber);
        }
    }

    private void checkInRange(Integer lottoNumber) {
        if (lottoNumber < LOTTO_MINIMUM_NUMBER || lottoNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);
        if (lottoNumbersSet.size() != LOTTO_RANGE_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX_MASSAGE + ERROR_DUPLICATE_MASSAGE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}