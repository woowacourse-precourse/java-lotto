package lotto;

import lotto.ui.LottoConsole;

public class LottoController {

    private final LottoService lottoService;
    private final LottoConsole lottoConsole;

    public LottoController(LottoService lottoService, LottoConsole lottoConsole) {
        this.lottoService = lottoService;
        this.lottoConsole = lottoConsole;
    }

    public void executeGame() {
        String lottoPrice = lottoConsole.inputLottoPrice();
        lottoService.storeLottoPrice(lottoPrice);

        lottoService.publishLottos();
        lottoService.showLottoResult();
    }
}
