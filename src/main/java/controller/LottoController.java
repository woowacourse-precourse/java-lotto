package controller;

import domain.LottoPurAmount;

public class LottoController {
    InputController inputController = new InputController();
    public void lottoStart() {
        Integer lottopuramount = inputController.insertLottoAmount();
        LottoPurAmount lottoPurAmount = new LottoPurAmount(lottopuramount);
    }
}
