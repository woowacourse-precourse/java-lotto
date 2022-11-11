package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }
}
