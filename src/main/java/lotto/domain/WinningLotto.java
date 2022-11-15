package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBER_BEGIN;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> lottoNumbers, Integer bonusNumber) {
        validateContainsBonusNumber(lottoNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateContainsBonusNumber(List<Integer> lottoNumbers, Integer bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 보너스 번호입니다.");
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(
                String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_NUMBER_BEGIN,
                    LOTTO_NUMBER_END));
        }
    }

    boolean isInvalidRange(int number) {
        return number < LOTTO_NUMBER_BEGIN || number > LOTTO_NUMBER_END;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
