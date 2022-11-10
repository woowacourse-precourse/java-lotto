package lotto;

import lotto.service.Service;
import lotto.view.InputView;

public class Controller {
    Service service = new Service();

    public void run() {
        generateLotto();
    }

    private void generateLotto() {
        String lottoPrice = InputView.getLottoPrice();
        service.generateLottoList(lottoPrice);
    }
}
