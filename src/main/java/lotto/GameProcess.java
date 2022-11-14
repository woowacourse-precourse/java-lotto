package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.util.Constant;
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
        List<List<Integer>> firstResultList = Service.firstCompareLottoNumber(purchasedLotteries, winningNumbers);
        Service.scoreLotteries(firstResultList, bonusNumber);

        System.out.println(Constant.FIRSTPLACE);
        System.out.println(Constant.SECONDPLACE);
        System.out.println(Constant.THIDPLACE);
        System.out.println(Constant.FOURTHPLACE);
        System.out.println(Constant.FIFTHPLACE);

    }
}
