package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        //구입비용 입력
        Integer ticket = lottoService.insertMoney();

        //로또 구입
        List<Lotto> lottos = lottoService.purchaseLottos(ticket);

        //당첨 번호 입력
        List<Integer> winningLottoNumber = lottoService.inputWinningLottoNumber();

        //보너스 번호 입력
        WinningLotto winningLotto = lottoService.makeWinningLotto(winningLottoNumber);
    }
}
