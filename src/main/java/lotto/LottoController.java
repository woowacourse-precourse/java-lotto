package lotto;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void executeGame() {
        lottoService.inputLottoPrice();
        lottoService.publishLottos();
        lottoService.showLottoResult();
    }
}
