package lotto.controller;

import lotto.service.LottoInputService;

public class LottoController {
    private LottoInputService lottoInputService = LottoInputService.getInstance();

    public void inputLottoInfo() {
        try {
            String lottoPrice = lottoInputService.inputLottoPrice();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
