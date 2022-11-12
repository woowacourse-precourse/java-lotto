package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    LottoService lottoService = new LottoService();
    public int getPurchaseAmount() {
        return lottoService.getPurchaseAmount();
    }

}
