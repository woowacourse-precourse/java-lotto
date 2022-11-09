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
        List<Lotto> lottos = purchaseLotto(ticket);

        //당첨 번호 입력
    }

    public Integer insertMoney() {
        int inputMoney = Input.inputMoney();
        return lottoService.insertMoney(inputMoney);
    }

    public List<Lotto> purchaseLotto(Integer ticket) {
        Output.purchaseLotto(ticket);
        List<Lotto> lottos = lottoService.purchaseLottos(ticket);
        Output.printPurchaseLottos(lottos);
        return lottos;
    }
}
