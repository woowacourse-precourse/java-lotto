package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        LottoValidator.validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    // TODO: 추가 기능 구현
}
