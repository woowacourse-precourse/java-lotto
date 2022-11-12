package lotto.domain;

import lotto.utils.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        LottoValidator.validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public long matchCount(Lotto userLotto) {
        return lottoNumbers.stream()
                .filter(userLotto::contain)
                .count();
    }

    public boolean contain(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return OPEN_BRACKET + lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(COMMA_WITH_BLANK)) + CLOSED_BRACKET;
    }
}
