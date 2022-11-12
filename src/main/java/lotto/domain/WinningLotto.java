package lotto.domain;

import static lotto.validator.LottoNumberValidator.validateBonusNumberAndLottoAreDuplicate;
import static lotto.validator.LottoNumberValidator.validateRangeOfNumber;

import java.util.List;

public class WinningLotto {
    private final Lotto lottoWithWinning;
    private final int bonusNumber;

    public WinningLotto(Lotto lottoWithWinning, int bonusNumber) {
        validateRangeOfNumber(bonusNumber);
        validateBonusNumberAndLottoAreDuplicate(lottoWithWinning, bonusNumber);

        this.lottoWithWinning = lottoWithWinning;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return lottoWithWinning.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
