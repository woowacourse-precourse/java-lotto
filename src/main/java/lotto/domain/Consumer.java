package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final static int PURCHASE_UNIT = 1000;
    private List<Lotto> lotteries;

    public void purchase() {
        OutputView outputView = new OutputView();
        int purchasePrice = new InputView().readPurchasePrice();

        validatePrice(purchasePrice);
        lotteries = getLotteries(purchasePrice);
        outputView.printLotteries(lotteries);
    }

    private void validatePrice(int price) {
        if (price < PURCHASE_UNIT || price % PURCHASE_UNIT != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다. (최소 금액 1,000원)");
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> getLotteries(int purchasePrice) {
        List<Lotto> lotteries = new ArrayList<>();
        LotteryWheel lotteryWheel = new LotteryWheel();

        while (purchasePrice > 0) {
            Lotto lotto = new Lotto(lotteryWheel.generateLotteryNumbers());
            lotteries.add(lotto);
            purchasePrice -= PURCHASE_UNIT;
        }

        return lotteries;
    }

    public List<Lotto> lotteries() {
        return lotteries;
    }
}
