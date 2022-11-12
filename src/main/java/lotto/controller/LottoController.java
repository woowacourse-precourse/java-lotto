package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    private InputView inputView;
    private LottoMoney lottoMoney;
    private Lottos lottos;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoMoney = new LottoMoney();
        this.lottos = new Lottos();
    }

    public void run() {
        inputView.printRequest();
        lottoMoney.inputMoney(Console.readLine());
        lottos.buy(lottoMoney.getLottoQuantity());
    }
}
