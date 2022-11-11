package lotto.controller;

import java.util.Collections;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        Purchase issueCount = new Purchase(InputView.inputCash());

        OutputView.printIssueCount(issueCount.get());

        for (int i = 0; i < issueCount.get(); i++) {
            Player player = new Player();
            List<Integer> playerNumbers = player.get();
            Collections.sort(playerNumbers);
            System.out.println(playerNumbers);
        }

        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonusNumber = new Bonus(InputView.inputBonusNumber());

        System.out.println("Winning Numbers: " + lotto.get());
        System.out.println("Bonus Number: " + bonusNumber.get());
        if (lotto.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }



    }
}
