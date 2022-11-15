package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.service.RankService;
import lotto.view.LottoUi;

import java.util.List;

import static lotto.view.LottoUi.printTotalProfitMessage;
import static lotto.view.MoneyUi.inputMoney;
import static lotto.view.RankUi.printRanking;

public class LottoUtils {
    private static final LottoUtils lottoUtils = new LottoUtils();

    public static LottoUtils getLottoUtils() {
        return lottoUtils;
    }

    private final RankService rankService = RankService.getRankService();
    private final LottoService lottoService = LottoService.getLottoService();
    private final LottoUi lottoUi = LottoUi.getLottoUi();


    public void start() {
        Money money = inputMoney();
        List<Lotto> lottos = lottoUi.purchaseLotto(money);
        Lotto winningLotto = lottoUi.inputWinningLotto();
        int bonusNumber = lottoUi.inputBonusNumber();
        Rank rank = rankService.getLottoDrawResult(lottos, winningLotto, bonusNumber);
        String profitPercentage = rankService.getProfitPercentage(rank, money.getMoney());

        printRanking(rank);
        printEnter();
        printTotalProfitMessage(profitPercentage);
    }

    public static void printEnter() {
        System.out.println();
    }
}
