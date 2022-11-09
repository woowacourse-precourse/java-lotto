package lotto.domain;

import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.WinningNumbers;

public class LottoMachine {

    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "중복 숫자는 입력될 수 없습니다.";

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoMachine(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumbers)) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
