package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Purchase;
import lotto.view.InputView;

public class LottoController {
    private static int ticketNumber;
    private static List<List<Integer>> allPlayerNumbers = new ArrayList<>();
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void run() {
        Purchase purchase = new Purchase(InputView.inputCash());
        ticketNumber = purchase.get();
        createAllPlayerNumbers(purchase);

        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonus = new Bonus(InputView.inputBonusNumber());
        winningNumbers = lotto.get();
        bonusNumber = bonus.get();
        validateDuplicates();

    }

    private static void validateDuplicates() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private static void createAllPlayerNumbers(Purchase issueCount) {
        for (int i = 0; i < issueCount.get(); i++) {
            List<Integer> playerNumbers = new ArrayList<>(new Player().get());
            allPlayerNumbers.add(playerNumbers);
        }
    }


}
