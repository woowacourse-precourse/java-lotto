package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningLotto;
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
        user.buyLottos(lottoAmount);

        for(Lotto lotto : user.getLottos()){
            message.lottoDetailMessage(lotto);
        }

        String inputWinningNumber = message.inputWinningNumberMessage();
        List<Integer> winningNumber = lottoService.setWinningNumber(inputWinningNumber);
        String inputBonusNumber = message.inputBonusNumberMessage();
        int bonusNumber = lottoService.setBonusNumber(inputBonusNumber);

        WinningLotto winningLotto = lottoService.setWinningLotto(winningNumber,bonusNumber);

        user.getLottoResults(winningLotto);


        message.lottoResultMessage();
    }

}
