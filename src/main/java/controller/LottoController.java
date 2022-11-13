package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoNumberList;
import domain.LottoPurAmount;
import lotto.Lotto;
import view.InputView;
import view.OutputView;

public class LottoController {
    InputController inputController = new InputController();
    String bonusnumber;
    public void lottoStart() {
        InputView.printLottoPrice();
        Integer lottopuramount = inputController.insertLottoAmount();
        LottoPurAmount lottoPurAmount = new LottoPurAmount(lottopuramount);
        OutputView.printBuyLottoNumber(lottoPurAmount);

        LottoNumberList lottoNumberList = new LottoNumberList(inputController.makeLottoNumberList(lottoPurAmount));
        OutputView.printAllLottoNumber(lottoNumberList.getLottolist());

        InputView.printInputLottoNumber();
        Lotto lotto = new Lotto(inputController.insertLottoNumber());
        InputView.printInputBonusNumber();
        bonusnumber = Console.readLine();
        InputView.printWinResult();
    }
}