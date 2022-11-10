package lotto;

import lotto.service.Service;
import lotto.view.InputView;

public class Controller {
    Service service = new Service();

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        String lottoPrice = InputView.getLottoPrice();
        service.generateLottoList(lottoPrice);
    }
}
