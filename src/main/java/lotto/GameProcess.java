package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.view.Input;
import lotto.view.Output;

public class GameProcess {
    public static void gameStart() {
        Output.gameStart();

        int countPurchasing = Service.inputMoney();
        List<List<Integer>> purchasedLotteries = Service.makeLottoByRandomNumbers(countPurchasing);
        Output.informationOnPurchasedLottoNumbers(purchasedLotteries);

        Output.requestInputNumber();
        Lotto.getWinningNumbers();

        Output.requestBonusNumber();
        Lotto.getBonusNumber();
    }
}
