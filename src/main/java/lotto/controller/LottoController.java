package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class LottoController {
    private InputView inputView;
    private LottoMoney lottoMoney;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoMoney = new LottoMoney();
    }

    public void run() {
        inputView.printRequest();
        lottoMoney.inputMoney(Console.readLine());

    }
}
