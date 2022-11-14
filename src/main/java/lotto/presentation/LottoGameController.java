package lotto.presentation;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.BonusBall;
import lotto.domain.WinningBalls;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Match;
import lotto.domain.Balls;
import lotto.presentation.view.LottoGamePrinter;
import lotto.presentation.view.LottoGameReader;

public class LottoGameController {

    public static void start() {
        int lottoAmount = LottoGameReader.readLottoAmount();
        LottoGamePrinter.printLottoCount(lottoAmount/1000);
        List<Lotto> lottos = LottoService.getLottos(lottoAmount);
        LottoGamePrinter.printLottosOrderByAsc(lottos);

        GeneralWinNumber generalWinNumber = new GeneralWinNumber(LottoGameReader.readWinNumber());
        BonusNumber bonusNumber = new BonusNumber(LottoGameReader.readBonusNumber());
        WinNumber winNumber = LottoService.getWinNumber(generalWinNumber,bonusNumber);

        List<Match> matches = LottoService.match(lottos,winNumber);
        LottoGamePrinter.printMatchResult(matches);

        double profit = LottoService.calculateProfit(lottoAmount,Match.calculateTotalPrizeMonay(matches));
        LottoGamePrinter.printProfit(profit);
    }

}
