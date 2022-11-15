package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.domain.WinningHistory;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private LottoMoney lottoMoney;
    private Lottos lottos;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private OutputView outputView;
    private WinningHistory winningHistory;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMoney = new LottoMoney();
        this.lottos = new Lottos();
        this.winningNumber = new WinningNumber();
        this.bonusNumber = new BonusNumber();
        this.winningHistory = new WinningHistory();
    }

    public void run() {
        inputView.printLottoMoney();
        lottoMoney.inputMoney(Console.readLine());
        lottos.buy(lottoMoney.getLottoQuantity());
        outputView.printLottos(lottos.getLottos());
        inputView.printWinningNumber();
        winningNumber.inputWinningNumber(Console.readLine());
        inputView.printBonusNumber();
        bonusNumber.inputBonusNumber(Console.readLine());
        winningHistory.compareLotto(
                winningNumber.getWinningNumber(), bonusNumber.getBonusNumber(), lottos.getLottos());
        winningHistory.calculateYield(lottoMoney.getMoney());
        outputView.printWinningHistory(winningHistory.getWinningHistory());
        outputView.printYield(winningHistory.getYield());
    }
}
