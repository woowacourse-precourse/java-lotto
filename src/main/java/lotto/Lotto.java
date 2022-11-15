package lotto;

import lotto.constant.GameConstants;
import lotto.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        Validator.validateLength(lottoNumbers, GameConstants.LOTTO_NUMBERS_LENGTH);
        Validator.validateRange(lottoNumbers, GameConstants.LOTTO_NUMBERS_LENGTH);
        Validator.validateDuplication(lottoNumbers, GameConstants.LOTTO_NUMBERS_LENGTH);
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
