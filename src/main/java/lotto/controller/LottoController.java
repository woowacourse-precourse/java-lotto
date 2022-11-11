package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Player;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.view.InputView;

public class LottoController {
    public static void run() {
        Purchase issueCount = new Purchase(InputView.inputMoney());

        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonusNumber = new Bonus(InputView.inputBonusNumber());

        System.out.println("Winning Numbers: " + lotto.get());
        System.out.println("Bonus Number: " + bonusNumber.get());
        if (lotto.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }

        for (int i = 0; i < issueCount.get(); i++) {
            Player playerNumbers = new Player();
            System.out.println(playerNumbers.get());
        }

    }
}
