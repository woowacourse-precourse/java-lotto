package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;
import lotto.domain.Purchase;
import lotto.view.InputView;

public class LottoController {
    private static int ticketNumber;
    private static List<List<Integer>> allplayerNumbers = new ArrayList<>();
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void run() {
        // buy tickets and get player numbers
        Purchase purchase = new Purchase(InputView.inputCash());
        ticketNumber = purchase.get();
        Player player = new Player(ticketNumber);
        allplayerNumbers = player.get();

        // set winning numbers, bonus number
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        Bonus bonus = new Bonus(InputView.inputBonusNumber());
        winningNumbers = lotto.get();
        bonusNumber = bonus.get();
        validateDuplicates();

        // calculate result
        LottoResult result = new LottoResult(winningNumbers, allplayerNumbers, bonusNumber);
    }

    private static void validateDuplicates() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
