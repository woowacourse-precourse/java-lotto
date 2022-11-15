package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.LottoUtils;
import lotto.view.Message;

public class LottoController {

    private User user;
    private Message message = new Message();
    private LottoService lottoService = new LottoService();

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            message.errorMessage();
        }
    }

    public void start() {
        user = new User();

        user.buyLottos(getLottoAmount());
        showLottoDetail();
        user.getLottoResults(setWinningLotto());
        showLottoResult();
    }

    public int getLottoAmount() {
        String inputPayment = message.inputPaymentMessage();
        int lottoPayment = LottoUtils.inputToNumber(inputPayment);
        user.setLottoPayment(lottoPayment);

        int lottoAmount = lottoService.buyLotto(lottoPayment);
        message.buyLottoMessage(lottoAmount);
        return lottoAmount;
    }

    public void showLottoDetail() {
        for (Lotto lotto : user.getLottos()) {
            message.lottoDetailMessage(lotto);
        }
    }

    public WinningLotto setWinningLotto() {
        return new WinningLotto(inputWinningNumber(), inputBonusNumber());
    }

    public List<Integer> inputWinningNumber() {
        String inputWinningNumber = message.inputWinningNumberMessage();
        return lottoService.setWinningNumber(inputWinningNumber);
    }

    public int inputBonusNumber() {
        String inputBonusNumber = message.inputBonusNumberMessage();
        return lottoService.setBonusNumber(inputBonusNumber);
    }

    public void showLottoResult() {
        message.lottoResultMessage();
        message.lottoProfitMessage(user.getLottoProfitRate());
    }
}
