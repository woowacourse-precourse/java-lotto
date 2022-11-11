package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private long bonusNumber;

    public BonusNumber() {
          makeBonusNumber();
    }
    
    public long getBonusNumber() {
        return bonusNumber;
    }

    private void makeBonusNumber() {
        bonusNumber = readBonusNumber();
    }

    private long readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
