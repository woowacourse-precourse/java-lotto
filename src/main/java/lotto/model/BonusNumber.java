package lotto.model;

import static lotto.Util.removeSpace;
import static lotto.Util.verifyRangeOfLottoNumber;

import lotto.view.InputView;

public class BonusNumber {
    public BonusNumber() {
        String input = removeSpace(InputView.inputBonusNumber());
        verifyRangeOfLottoNumber(Integer.parseInt(input));
    }
}
