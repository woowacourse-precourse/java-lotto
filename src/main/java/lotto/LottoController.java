package lotto;

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
    }

    private void setWinningNumbers() {

    }

    private void result() {

    }

}
