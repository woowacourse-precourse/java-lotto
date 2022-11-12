package controller;

import domain.LottoNumberList;
import domain.LottoPurAmount;
import view.InputView;
import view.OutputView;

public class LottoController {
    InputController inputController = new InputController();
    public void lottoStart() {
        InputView.printLottoPrice();
        Integer lottopuramount = inputController.insertLottoAmount();
        LottoPurAmount lottoPurAmount = new LottoPurAmount(lottopuramount);
        OutputView.printBuyLottoNumber(lottoPurAmount);

        LottoNumberList lottoNumberList = new LottoNumberList(inputController.makeLottoNumberList(lottoPurAmount));
        OutputView.printAllLottoNumber(lottoNumberList.getLottolist());

        InputView.printInputBonusNumber();
    }
}