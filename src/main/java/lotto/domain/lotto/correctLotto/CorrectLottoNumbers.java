package lotto.domain.lotto.correctLotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.util.Validate;

import java.util.List;

public class CorrectLottoNumbers {
    private final String WARM = "[ERROR] ";
    private final String WARM_CORRECT_LOTTO_NUMBERS_SIZE = WARM + "로또 당첨 번호는 7개이어야 합니다.";
    private final int CORRECT_LOTTO_NUMBER_SIZE = 7;
    private final int BONUS_INDEX = 6;


    private final List<LottoNumber> correctLottoNumbers;

    private final LottoNumber bonusNumber;

    public CorrectLottoNumbers(List<LottoNumber> correctLottoNumbers) {
        validate(correctLottoNumbers);
        this.correctLottoNumbers = correctLottoNumbers;
        this.bonusNumber = correctLottoNumbers.get(BONUS_INDEX);
    }

    private void validate(List<LottoNumber> numbers) {
        Validate.validateSize(numbers, WARM_CORRECT_LOTTO_NUMBERS_SIZE,
                (lottoNumbers) -> lottoNumbers.size() != CORRECT_LOTTO_NUMBER_SIZE);
    }
}
