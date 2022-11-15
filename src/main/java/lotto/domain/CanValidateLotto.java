package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.LottoNumberOutOfBoundException;

public abstract class CanValidateLotto<T> implements CanValidate<T> {
    public void validateNumberIsInRange(int number) {
        if (number > LottoRule.MAXIMUM_NUMBER.getValue()
                || number < LottoRule.MINIMUM_NUMBER.getValue()) {
            throw new LottoNumberOutOfBoundException();
        }
    }
}
