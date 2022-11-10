package lotto;

import lotto.model.BonusNumber;
import lotto.model.PlayerNumber;
import lotto.model.WinningNumber;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }
}
