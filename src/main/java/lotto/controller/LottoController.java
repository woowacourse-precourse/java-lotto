package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class LottoController {
    private InputView inputView;
    private LottoMoney money;

    public LottoController() {
        this.inputView = new InputView();
        this.money = new LottoMoney();
    }

    public void run() {
        inputView.printRequest();
        money.inputMoney(Console.readLine());

    }
}
