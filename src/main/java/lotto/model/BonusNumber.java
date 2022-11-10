package lotto.model;

import static lotto.Util.removeSpace;
import static lotto.Util.verifyRangeOfLottoNumber;

import lotto.view.InputView;

public class BonusNumber {
    private static int bonusNumber;

    public BonusNumber() {
        int input = Integer.parseInt(removeSpace(InputView.inputBonusNumber()));
        verifyRangeOfLottoNumber(input);
        if(WinningNumber.winningNumbers.contains(input)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = input;
    }
}
