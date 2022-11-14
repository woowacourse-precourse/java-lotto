package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.view.Output;

public class GameProcess {
    public static void gameStart() {
        Output.gameStart();

        int countPurchasing = Service.inputMoney();
        List<List<Integer>> purchasedLotteries = Lotto.makeLottoByRandomNumbers(countPurchasing);
        Output.informationOnPurchasedLottoNumbers(purchasedLotteries);

        Output.requestInputNumber();
        List<Integer> winningNumbers = Lotto.getWinningNumbers();

        Output.requestBonusNumber();
        int bonusNumber = Lotto.getBonusNumber();

        Output.beginAnnouncementOfResult();
        Service.firstCompareLottoNumber(purchasedLotteries, winningNumbers, bonusNumber);
    }
}
