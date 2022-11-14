package lotto.domain;

import lotto.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.GameConstants.*;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        Validator.validateLength(lottoNumbers, LOTTO_NUMBERS_LENGTH);
        Validator.validateRange(lottoNumbers, LOTTO_NUMBERS_LENGTH);
        Validator.validateDuplication(lottoNumbers, LOTTO_NUMBERS_LENGTH);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
