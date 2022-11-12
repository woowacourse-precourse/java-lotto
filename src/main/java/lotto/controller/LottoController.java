package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class LottoController {
    private InputView inputView;
    private LottoMoney lottoMoney;
    private Lottos lottos;
    private WinningNumber winningNumber;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoMoney = new LottoMoney();
        this.lottos = new Lottos();
        this.winningNumber = new WinningNumber();
    }
    //메소드명 필수 확인
    public void run() {
        inputView.printRequest();
        lottoMoney.inputMoney(Console.readLine());
        lottos.buy(lottoMoney.getLottoQuantity());
        inputView.printWinningNumber();
        winningNumber.inputWinningNumber(Console.readLine());
    }
}
