package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final WinningNumber winningNumber;
    private final Status status;

    public LottoGame() {
        lottoGenerator = new LottoGenerator();
        winningNumber = new WinningNumber();
        status = new Status();
    }

    public void start() {
        try {
            int purchaseAmt = InputView.readPurchaseAmt();
            OutputView.printLottoCount(purchaseAmt);

            List<Lotto> lottoList = lottoGenerator.generateLotto(purchaseAmt);
            OutputView.printLotto(lottoList);

            winningNumber.makeWinningNumber(InputView.readWinningNumber(), InputView.readBonusNumber());

            status.findMatch(lottoList, winningNumber);
            status.calculateRateOfReturn(purchaseAmt);

            OutputView.printResult(status.makeResult());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
