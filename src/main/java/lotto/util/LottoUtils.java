package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.service.RankService;

import java.util.List;

import static lotto.view.LottoUi.*;
import static lotto.view.MoneyUi.*;
import static lotto.view.RankUi.*;

public class LottoUtils {
    private static LottoUtils lottoUtils = new LottoUtils();
    RankService rankService = RankService.getRankService();
    MoneyService moneyService = MoneyService.getMoneyService();
    LottoService lottoService = LottoService.getLottoService();

    public static LottoUtils getLottoUtils() {
        return lottoUtils;
    }

    public void start() {
        Money money = inputMoney();
        List<Lotto> lottos = purchaseLotto(money);
        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber();
        Rank rank = rankService.getLottoDrawResult(lottos, winningLotto, bonusNumber);
        String profitPercentage = lottoService.getProfitPercentage(rank, money.getMoney());

        printRanking(rank);
        printEnter();
        printTotalProfitMessage(profitPercentage);
    }

    public static void printEnter() {
        System.out.println();
    }
}
