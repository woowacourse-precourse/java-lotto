package lotto.domain.lotto.presentation.dto;

import lotto.domain.lotto.service.LottoService;

public class LottoController {

    LottoService lottoService = new LottoService();

    public int inputMoney() {
        return lottoService.getInputMoney();
    }

}
