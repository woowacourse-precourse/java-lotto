package lotto.model;

import static lotto.Util.removeSpace;

import lotto.view.InputView;

public class BonusNumber {
    public BonusNumber() {
        String input = removeSpace(InputView.inputBonusNumber());
        System.out.println(input);
    }
}
