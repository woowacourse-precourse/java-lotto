package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

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
                LottoRule.AMOUNT_OF_NUMBER.getValueForRule() +
                        LottoRule.AMOUNT_OF_BONUS.getValueForRule()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }

        for (Integer number : winningNumbers.keySet()) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(Integer key) {
        if (key>LottoRule.MAXIMUM_NUMBER.getValueForRule() ||
                key<LottoRule.MINIMUM_NUMBER.getValueForRule()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static WinningLotto of(Map<Integer, Boolean> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }
}
