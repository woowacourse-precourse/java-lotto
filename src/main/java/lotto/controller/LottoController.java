package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static List<List<Integer>> allPlayerNumbers = new ArrayList<>();
    private static Lotto lotto;
    private static Bonus bonusNumber;

    public static void run() {
        Purchase issueCount = new Purchase(InputView.inputCash());
        createAllPlayerNumbers(issueCount);

        lotto = new Lotto(InputView.inputWinningNumbers());
        bonusNumber = new Bonus(InputView.inputBonusNumber());

        validateDuplicates();

    }

    private static void validateDuplicates() {
        if (lotto.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private static void createAllPlayerNumbers(Purchase issueCount) {
        for (int i = 0; i < issueCount.get(); i++) {
            List<Integer> playerNumbers = new ArrayList<>(new Player().get());
            sortInAscendingOrders(playerNumbers);
            OutputView.printPlayerNumbers(playerNumbers);
            allPlayerNumbers.add(playerNumbers);
        }
    }

    private static void sortInAscendingOrders(List<Integer> playerNumbers) {
        Collections.sort(playerNumbers);
    }
}
