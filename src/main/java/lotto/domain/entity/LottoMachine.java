package lotto.domain.entity;

import static lotto.common.message.ExceptionMessage.BONUS_NUMBER_DUPLICATION_MESSAGE;
import static lotto.common.message.ExceptionMessage.ERROR_CODE;

import java.util.Collections;
import java.util.List;
import lotto.common.message.ExceptionMessage;

public class LottoMachine {

    private Lotto lottoNumbers;
    private int bonusNumber;

    private LottoMachine(List<Integer> lottoNumbers, int bonusNumber) {

        Collections.sort(lottoNumbers);

        this.lottoNumbers = new Lotto(lottoNumbers);

        bonusNumberValidation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberValidation(int bonusNumber) {
        if (lottoNumbers.currentLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ERROR_CODE + BONUS_NUMBER_DUPLICATION_MESSAGE);
        }
    }

    public static LottoMachine of(List<Integer> lottoNumbers, int bonusNumber) {
        return new LottoMachine(lottoNumbers, bonusNumber);
    }
}
