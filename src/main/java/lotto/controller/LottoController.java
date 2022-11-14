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

    public int buyLotto(User user){
        String inputPayment = message.inputPaymentMessage();
        int lottoPayment = lottoService.inputPaymentToNumber(inputPayment);
        user.setLottoPayment(lottoPayment);

        int lottoAmount = lottoService.buyLotto(lottoPayment);
        message.buyLottoMessage(lottoAmount);
        return lottoAmount;
    }
    public void start(){

        User user = new User();
        int lottoAmount = buyLotto(user);//로또 구매 금액 입력// 몇개 구매 ~

        user.buyLottos(lottoAmount);

        for(Lotto lotto : user.getLottos()){
            message.lottoDetailMessage(lotto);
        }
// 구매한거 디테일


        String inputWinningNumber = message.inputWinningNumberMessage();
        List<Integer> winningNumber = lottoService.setWinningNumber(inputWinningNumber);
// 당첨 번호 입력

        String inputBonusNumber = message.inputBonusNumberMessage();
        int bonusNumber = lottoService.setBonusNumber(inputBonusNumber);
// 보너스 번호 입력
        WinningLotto winningLotto = lottoService.setWinningLotto(winningNumber,bonusNumber);
 // 당첨번호 설정

// 당첨 통계
        user.getLottoResults(winningLotto);
        message.lottoResultMessage();
        message.lottoProfitMessage(user.getLottoProfit());
    }
}
