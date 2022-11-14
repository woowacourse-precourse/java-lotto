package lotto.controller;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.vo.LottoPurchaseInfo;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLotto() {
        // 1. 로또 구매
        LottoPurchaseInfo lottoPurchaseInfo = LottoPurchase();

    }

    private LottoPurchaseInfo LottoPurchase() {
        int lottoPrice = ConvertMoneyStringToInteger(inputView.getPrice());
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(lottoPrice);
        outputView.printPurchaseMessage(lottoPurchaseInfo.getLottoGameCount());
        return lottoPurchaseInfo;
    }

    private void CreateLottoNumbers() {

    }

    private int ConvertMoneyStringToInteger(String money) {
        return Integer.parseInt(money);
    }
}
