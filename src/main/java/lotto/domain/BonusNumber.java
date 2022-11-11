package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private long bonusNumber;

    public void makeBonusNumber() {
        bonusNumber = readBonusNumber();
    }

    public long getBonusNumber() {
        return bonusNumber;
    }
    
    private long readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
