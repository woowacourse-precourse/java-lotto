package lotto;

import lotto.Money;
import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoNumber;
import lotto.WinNumbers;
import lotto.Result;
import java.util.ArrayList;
import java.util.List;
import lotto.NumsGenerator;
import lotto.Util;
import lotto.InputView;
import lotto.OutputView;

public class MainController {
    public void run() {
        final Money money = makeMoney();
        final List<Lotto> lottoTickets = makeLottos(money.toLottoCount());
        final WinNumbers winNumbers = makeWinNums();

        final Result result = new Result(lottoTickets, winNumbers);
        end(result, money);
    }

    private Money makeMoney() {
        return new Money(InputView.inputMoney());
    }

    private List<Lotto> makeLottos(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoFactory.createLotto(NumsGenerator.generateByRandom()));
        }
        OutputView.printLottoTickets(lottos);
        return lottos;
    }

    private WinNumbers makeWinNums() {
        List<Integer> winLottoRawNums = InputView.inputWinLottoNums();
        LottoNumber bonus = LottoNumber.from(InputView.inputBonusNumber());
        return LottoFactory.createWinNums(NumsGenerator.generate(winLottoRawNums), bonus);
    }

    private void end(final Result result, final Money money) {
        OutputView.printLottosResult(result);
        OutputView.printProfit(Util.getProfit((float) result.getPrize(), (float) money.get()));
    }
}