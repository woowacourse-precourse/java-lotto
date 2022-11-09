package lotto.controller;

import lotto.service.LottoService;
import lotto.view.Input;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run(){
        //구입비용 입력
        int inputMoney = Input.inputMoney();
        lottoService.insertMoney(inputMoney);
        //
    }
}
