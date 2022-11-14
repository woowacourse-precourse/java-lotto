package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoNumberRule.LOTTO_RANGE_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_COUNT.getValue());
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            checkInRange(lottoNumber);
        }
    }

    private void checkInRange(Integer lottoNumber) {
        if (lottoNumber < LottoNumberRule.LOTTO_MINIMUM_NUMBER.getValue()
            || lottoNumber > LottoNumberRule.LOTTO_MAXIMUM_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getValue());
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersCollection = new HashSet<>(lottoNumbers);
        if (lottoNumbersCollection.size() != LottoNumberRule.LOTTO_RANGE_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_DUPLICATE.getValue());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}