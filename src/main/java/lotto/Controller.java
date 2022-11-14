package lotto;

public class Controller {
    public void run() {
        getLottoInfo();
    }

    private void getLottoInfo() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);
    }
}
