package lotto;

import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoMoney;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.Result;
import lotto.domain.result.TicketCount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Gameplay {
    private Gameplay(){

    }

    public static Gameplay create() {
        return new Gameplay();
    }

    private static float getProfit(final float nowMoney, final float pastMoney) {
        return nowMoney / pastMoney;
    }

    public void run() {
        final LottoMoney lottoMoney = makeLottoMoney();
        final TicketCount count = makeLottoTicketCount(lottoMoney);
        final LottoGroup lottoTickets = makeLottos(count);
        ResultView.printLottoTickets(count, lottoTickets);

        final WinningLotto winningLotto = makeWinNums();

        final Result result = Result.of(lottoTickets, winningLotto);
        end(result, lottoMoney);
    }

    private LottoMoney makeLottoMoney() {
        return LottoMoney.from(
                InputView.inputMoney());
    }

    private TicketCount makeLottoTicketCount(final LottoMoney money) {
        return TicketCount.of(money.toLottoCount(),
                InputView.inputManualTicketCount());
    }

    private LottoGroup makeLottos(final TicketCount count) {
        return LottoFactory.createLottos(count,
                InputView.inputManualNums(count.ofManual()));
    }

    private WinningLotto makeWinNums() {
        return LottoFactory.createWinNums(InputView.inputWinLottoNums(), InputView.inputBonusNumber());
    }

    private void end(final Result result, final LottoMoney lottoMoney) {
        ResultView.printLottosResult(result);
        ResultView.printProfit(getProfit((float) result.getPrize(), (float) lottoMoney.get()));
    }
}
