package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.Message;

public class LottoController {

    private Message message = new Message();
    private LottoService lottoService = new LottoService();

    public void start(){
        String inputPayment = message.inputPaymentMessage();
        int lottoAmount = lottoService.buyLotto(inputPayment);
        message.buyLottoMessage(lottoAmount);

        User user = new User();
        user.setLottos(lottoAmount);

        for(Lotto lotto : user.getLottos()){
            message.lottoDetailMessage(lotto);
        }

        String inputWinningNumber = message.inputWinningNumberMessage();
    }

}
