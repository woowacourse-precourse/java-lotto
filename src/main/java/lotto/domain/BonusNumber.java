package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionPhrase.EXCEPTION_BONUS_NUMBER_DUPLICATED;
import static lotto.exception.ExceptionPhrase.EXCEPTION_OUT_OF_RANGE;

public class BonusNumber {

    private int bonus;

    private List<Integer> lottoNumbers;

    public BonusNumber(int bonus, List<Integer> lottoNumbers) {
        this.bonus = bonus;
        validate(bonus);
        duplicateLottoNumber(bonus, lottoNumbers);
    }

    private void validate(int bonus) {
        if(bonus < 0 || bonus>45) {
            throw new IllegalArgumentException(EXCEPTION_OUT_OF_RANGE.getMessage());
        }
    }
    private void duplicateLottoNumber(int bonus, List<Integer>lottoNumber) {
        if(lottoNumber.contains(bonus)) {
            throw new IllegalArgumentException(EXCEPTION_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    public int getBonus() {
        return bonus;
    }
}
