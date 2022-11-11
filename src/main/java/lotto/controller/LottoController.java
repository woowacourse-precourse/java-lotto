package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoController {
    public static void run() {
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        System.out.println("Winning Numbers: " + lotto.get());
        System.out.println("Bonus Number: " + bonusNumber.get());
        if (lotto.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
