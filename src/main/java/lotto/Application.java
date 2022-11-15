package lotto;

import lotto.domain.Lottery;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printPurchaseGuideMessage();
        PurchaseMoney purchaseMoney = InputView.inputPurchaseMoney();

        int lottoCount = purchaseMoney.getLottoCount();
        OutputView.printPurchaseResultMessage(lottoCount);

        Lottery lottery = new Lottery(lottoCount);
        OutputView.printLottoNumbers(lottery);
    }
}
