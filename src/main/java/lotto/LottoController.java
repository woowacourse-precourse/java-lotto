package lotto;

import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        buyLottos();
        setWinningNumbers();
        result();
    }

    private void buyLottos() {
        String inputMoney = InputView.inputMoney();
        int money;
        try {
            money = Integer.parseUnsignedInt(inputMoney);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 음수를 제외한 숫자만 입력해주세요.");
        }
    }

    private void setWinningNumbers() {

    }

    private void result() {

    }

}
