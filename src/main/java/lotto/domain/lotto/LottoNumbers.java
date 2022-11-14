package lotto.domain.lotto;

import lotto.domain.lotto.util.Validate;

import java.util.List;

public class LottoNumbers {

    private final String WARM = "[ERROR] ";
    private final int LOTTO_NUMBER_SIZE = 6;
    private final String WARM_LOTTO_NUMBERS_SIZE = WARM + "로또 번호는 " + LOTTO_NUMBER_SIZE + "개이어야 합니다.";


    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        validateDuplicatedNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }


    private void validate(List<LottoNumber> numbers) {
        Validate.validateSize(numbers, WARM_LOTTO_NUMBERS_SIZE,
                lottoNumbers -> lottoNumbers.size() != LOTTO_NUMBER_SIZE);
    }

    private void validateDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Validate.validateDuplicateNumber(lottoNumbers,
                (baseSize, compareLottoNumbers) -> baseSize != compareLottoNumbers.size());
    }

}