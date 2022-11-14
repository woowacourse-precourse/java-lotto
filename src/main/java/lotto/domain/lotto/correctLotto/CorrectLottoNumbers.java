package lotto.domain.lotto.correctLotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.util.Validate;

import java.util.List;

public class CorrectLottoNumbers {
    private final int BONUS_INDEX = 6;


    private final List<LottoNumber> correctLottoNumbers;

    private final LottoNumber bonusNumber;

    public CorrectLottoNumbers(List<LottoNumber> correctLottoNumbers) {
        this.correctLottoNumbers = correctLottoNumbers;
        this.bonusNumber = correctLottoNumbers.get(BONUS_INDEX);
    }

}
