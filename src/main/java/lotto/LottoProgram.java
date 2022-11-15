package lotto;

import view.InputView;
import view.OutputView;

import static view.InputView.*;
import static view.OutputView.*;

public class LottoProgram {
    public void run() {
        LottoMoney lottoMoney = ReceiveMoney();
        LottoCount lottoCount = calculateLottoCount(lottoMoney);
        OutputView.printLottoCount(lottoCount);
        LottoCollection lottoCollection = makeLottoNumber(lottoCount);
        printLottoCollection(lottoCollection);
        WinningNumber winningNumber = makeWinningNumber();
        LottoRank lottoRank = makeRank(lottoCollection, winningNumber);
        printWinningResult(lottoRank);
        printRewardRatio(lottoMoney, lottoRank);
    }

    private LottoMoney ReceiveMoney() {
        return new LottoMoney(inputMoneyView());
    }

    private LottoCount calculateLottoCount(LottoMoney lottoMoney) {
        return new LottoCount(lottoMoney.changeToLottoCount());
    }

    private LottoCollection makeLottoNumber(LottoCount lottoCount) {
        return LottoMachine.CreateWinningNumber(lottoCount);
    }

    private WinningNumber makeWinningNumber() {
        return new WinningNumber(new Lotto(inputWinningNumberView()), inputBonusNumberView());
    }

    private LottoRank makeRank(LottoCollection lottoCollection, WinningNumber winningNumber) {
        return new LottoRank(lottoCollection, winningNumber);
    }
}
