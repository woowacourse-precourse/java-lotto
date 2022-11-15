package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber() {
          bonusNumber = readBonusNumber();
    }
    
    public int getBonusNumber() {
        return bonusNumber;
    }

    private int readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
