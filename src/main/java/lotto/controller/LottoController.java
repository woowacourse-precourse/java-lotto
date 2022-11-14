package lotto.controller;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.number.PayOut;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    public static void run() {
        PayOut payOut = getPayOut();

        LottoGroup lottoGroup = getPaidLottos(payOut);
    }

    private static LottoGroup getPaidLottos(PayOut payOut) {
        OutputView.newLine();

        int gameCount = payOut.getGameCount();
        OutputView.printLottoCount(gameCount);

        LottoGroup lottoGroup = lottoGenerator.generateLottos(gameCount);
        OutputView.printLottoNumbers(lottoGroup);

        return lottoGroup;
    }

    private static PayOut getPayOut() {
        OutputView.payout();

        return new PayOut(InputView.getInput());
    }
}
