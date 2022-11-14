package lotto;

import static lotto.domain.Service.getYield;
import static lotto.domain.Service.inputMoney;

import java.util.List;
import lotto.domain.Check;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.util.Constant;
import lotto.view.Output;

public class GameProcess {
    public static void gameStart() {
        Output.gameStart();

        double payMoney = inputMoney();
        double countPurchasing = Check.countBuyLotto(payMoney);
        List<List<Integer>> purchasedLotteries = Lotto.makeLottoByRandomNumbers(countPurchasing);
        Output.informationOnPurchasedLottoNumbers(purchasedLotteries);

        Output.requestInputNumber();
        List<Integer> winningNumbers = Lotto.getWinningNumbers();

        Output.requestBonusNumber();
        int bonusNumber = Lotto.getBonusNumber();

        Output.beginAnnouncementOfResult();
        List<List<Integer>> firstResultList = Service.firstCompareLottoNumber(purchasedLotteries, winningNumbers);
        Service.scoreLotteries(firstResultList, bonusNumber);
        String yield = getYield(payMoney);

        Output.resultAnnouncement(yield);

    }
}
