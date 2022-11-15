package lotto;

import static lotto.domain.Service.getInputMoney;
import static lotto.domain.Service.getYield;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.view.Output;

public class GameProcess {
    public static void gameStart() {
        Output.gameStart();

        double payMoney = getInputMoney();
        int countPurchasing = Service.countBuyLotto(payMoney);
        List<List<Integer>> purchasedLotteries = Lotto.makeLottoByRandomNumbers(countPurchasing);
        Output.informationOnPurchasedLottoNumbers(purchasedLotteries);

        Output.requestInputNumber();
        List<Integer> winningNumbers = Lotto.getWinningNumbers();

        Output.requestBonusNumber();
        int bonusNumber = Lotto.getBonusNumber(winningNumbers);

        Output.beginAnnouncementOfResult();
        List<List<Integer>> firstResultList = Service.firstCompareLottoNumber(purchasedLotteries, winningNumbers);
        Service.scoreLotteries(firstResultList, bonusNumber);
        String yield = getYield(payMoney);

        Output.resultAnnouncement(yield);
    }
}
