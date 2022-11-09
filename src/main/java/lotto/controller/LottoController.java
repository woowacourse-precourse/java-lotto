package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        //구입비용 입력
        Integer ticket = insertMoney();

        //로또 구입
        purchaseLotto(ticket);
    }

    public Integer insertMoney() {
        int inputMoney = Input.inputMoney();
        return lottoService.insertMoney(inputMoney);
    }

    public void purchaseLotto(Integer ticket) {
        Output.purchaseLotto(ticket);
        List<Lotto> lottos = lottoService.purchaseLottos(ticket);
        Output.printPurchaseLottos(lottos);
    }
}
