package lotto.controller;

import static lotto.ui.LottoConsole.printErrorMessage;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void executeGame() {
        try{
            lottoService.inputLottoPrice();

            lottoService.publishLottos();
            lottoService.showLottoResult();

            lottoService.inputWinningLottoNumbers();
            lottoService.inputBonusNumber();

            lottoService.calculateUserLottos();
            lottoService.showTotalLottoResult();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            printErrorMessage(e.getMessage());
        }

    }
}
