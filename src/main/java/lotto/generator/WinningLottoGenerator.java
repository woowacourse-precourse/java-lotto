package lotto.generator;

import static lotto.validator.UserInputValidator.validateStringIsNumeric;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class WinningLottoGenerator {

    public static WinningLotto generate(Lotto lottoWithWinningNumbers, int bonusNumber) {
        return new WinningLotto(lottoWithWinningNumbers, bonusNumber);
    }

    public static WinningLotto generate(Lotto lottoWithWinningNumbers, String bonusNumber) {
        validateStringIsNumeric(bonusNumber);
        return generate(lottoWithWinningNumbers, Integer.parseInt(bonusNumber));
    }
}
