package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.DuplicateLottoNumberException;

import java.util.Map;

public class WinningLottoValidator extends CanValidateLotto<Map<Integer, Boolean>> {
    @Override
    public void validate(Map<Integer, Boolean> winningNumbers) {
        if (winningNumbers.size() !=
                LottoRule.AMOUNT_OF_NUMBER.getValue() +
                        LottoRule.AMOUNT_OF_BONUS.getValue()) {
            throw new DuplicateLottoNumberException();
        }

        for (Integer number : winningNumbers.keySet()) {
            validateNumberIsInRange(number);
        }
    }
}
