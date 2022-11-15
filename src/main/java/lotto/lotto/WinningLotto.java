package lotto.lotto;

import java.util.List;
import lotto.exception.lotto.BonusNumberDuplicationError;

public class WinningLotto extends Lotto {

    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        super(winningNumbers);
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (!verifyBonusNumberNotDuplicated(winningNumbers, bonusNumber)) {
            throw new BonusNumberDuplicationError();
        }
    }

    private boolean verifyBonusNumberNotDuplicated(List<LottoNumber> winningNumbers,
            LottoNumber bonusNumber) {
        return !winningNumbers.contains(bonusNumber);
    }
}
