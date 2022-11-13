package lotto.controller;

import lotto.service.LottoService;
import lotto.view.Message;

public class LottoController {

    private Message message = new Message();
    private LottoService lottoService = new LottoService();

    public void start(){
        String inputPayment = message.inputPaymentMessage();
        lottoService.buyLotto(inputPayment);
    }
}
