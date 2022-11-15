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

    private final LottoService lottoService;
    private final LottoGameReader lottoGameReader;
    private final LottoGamePrinter lottoGamePrinter;

    public LottoGameController(LottoService lottoService, LottoGameReader lottoGameReader, LottoGamePrinter lottoGamePrinter) {
        this.lottoService = lottoService;
        this.lottoGameReader = lottoGameReader;
        this.lottoGamePrinter = lottoGamePrinter;
    }

    public void start() {
        LottoAmount lottoAmount = lottoService.getLottoAmount(lottoGameReader.readLottoAmount());
        lottoGamePrinter.printLottoCount(lottoAmount.getLottoCount());

        List<Lotto> lottos = lottoService.getLottos(lottoAmount);
        lottoGamePrinter.printLottosOrderByAsc(lottos);

        Balls balls = drawBalls(lottoGameReader.readGeneralWinNumbers(), lottoGameReader.readBonusNumber());

        List<Match> matches = lottoService.match(lottos, balls);
        lottoGamePrinter.printMatchResult(matches);

        double profit = lottoService.calculateProfit(lottoAmount.getLottoAmount(), Match.calculateTotalPrizeMoney(matches));
        lottoGamePrinter.printProfit(profit);
    }

    private Balls drawBalls(List<Integer> unwrapWinningBalls, int unwrapBonusBall) {
        WinningBalls winningBalls = new WinningBalls(unwrapWinningBalls);
        BonusBall bonusBall = new BonusBall(unwrapBonusBall);
        return lottoService.getBalls(winningBalls, bonusBall);
    }

}
