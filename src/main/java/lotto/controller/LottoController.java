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

    public int getLottoAmount(User user){
        String inputPayment = message.inputPaymentMessage();
        int lottoPayment = lottoService.inputPaymentToNumber(inputPayment);
        user.setLottoPayment(lottoPayment);

        int lottoAmount = lottoService.buyLotto(lottoPayment);
        message.buyLottoMessage(lottoAmount);
        return lottoAmount;
    }

    public void showLottoDetail(User user){
        for(Lotto lotto : user.getLottos()){
            message.lottoDetailMessage(lotto);
        }
    }

    public List<Integer> inputWinningNumber(){
        String inputWinningNumber = message.inputWinningNumberMessage();
        List<Integer> winningNumber = lottoService.setWinningNumber(inputWinningNumber);
        return winningNumber;
    }

    public int inputBonusNumber(){
        String inputBonusNumber = message.inputBonusNumberMessage();
        int bonusNumber = lottoService.setBonusNumber(inputBonusNumber);
        return bonusNumber;
    }

    public WinningLotto setWinningLotto() {
        return lottoService.setWinningLotto(inputWinningNumber(),inputBonusNumber());
    }

    public void showLottoResult(User user) {
        message.lottoResultMessage();
        message.lottoProfitMessage(user.getLottoProfit());
    }

    public void start(){
        User user = new User();
        int lottoAmount = getLottoAmount(user);

        user.buyLottos(lottoAmount);
        showLottoDetail(user);
        WinningLotto winningLotto = setWinningLotto();

        showLottoResult(user);
        user.getLottoResults(winningLotto);
    }


}
