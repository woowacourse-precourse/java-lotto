package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberOutOfBoundException;

import java.util.Map;

public class WinningLotto {
    /**
     * Key : 로또 번호
     * Value : bonus number이면 True
     */
    private final Map<Integer, Boolean> winningNumbers;

    public WinningLotto(Map<Integer, Boolean> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(Map<Integer, Boolean> winningNumbers) {
        if (winningNumbers.size() !=
                LottoRule.AMOUNT_OF_NUMBER.getValue() +
                        LottoRule.AMOUNT_OF_BONUS.getValue()) {
            throw new DuplicateLottoNumberException();
        }

        for (Integer number : winningNumbers.keySet()) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(Integer key) {
        if (key > LottoRule.MAXIMUM_NUMBER.getValue() ||
                key < LottoRule.MINIMUM_NUMBER.getValue()) {
            throw new LottoNumberOutOfBoundException();
        }
    }

    public static WinningLotto of(Map<Integer, Boolean> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }
}
