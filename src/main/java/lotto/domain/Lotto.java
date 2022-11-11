package lotto.domain;

import lotto.utils.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;
    private static final String COMMA = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        LottoValidator.validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
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
                .collect(Collectors.joining(COMMA)) + CLOSED_BRACKET;
    }
}
