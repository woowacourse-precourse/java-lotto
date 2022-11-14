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
    //메소드명 필수 확인
    public void run() {
        inputView.printRequest();
        lottoMoney.inputMoney(Console.readLine());
        lottos.buy(lottoMoney.getLottoQuantity());
        outputView.printLottos(lottos.getLottos());
        inputView.printWinningNumber();
        winningNumber.inputWinningNumber(Console.readLine());
        inputView.printBonusNumber();
        bonusNumber.inputBonusNumber(Console.readLine());
        winningHistory.compareLotto(winningNumber.getWinningNumber(), bonusNumber.getBonusNumber(), lottos.getLottos());
        outputView.printWinningHistory(winningHistory.getWinningHistory());
    }
}
