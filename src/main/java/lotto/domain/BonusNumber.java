package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber() {
          makeBonusNumber();
    }
    
    public int getBonusNumber() {
        return bonusNumber;
    }

    private void makeBonusNumber() {
        bonusNumber = readBonusNumber();
    }

    private int readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
