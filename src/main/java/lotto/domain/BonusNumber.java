package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private long bonusNumber;

    public long getBonusNumber() {
        makeBonusNumber();
        return bonusNumber;
    }

    private void makeBonusNumber() {
        bonusNumber = readBonusNumber();
    }

    private long readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
