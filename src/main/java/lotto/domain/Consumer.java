package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final static int LOTTO_PRICE_UNIT = 1000;
    private List<Lotto> lotteries;

    public void purchase() {
        int purchasePrice = new InputView().readPurchasePrice();
        validatePrice(purchasePrice);
        purchaseLotteries(purchasePrice);

        getLotteriesResult();
    }

    private void getLotteriesResult() {
        new LottoEstimator(WinningLotto.create()).estimate(lotteries);
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE_UNIT || price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다. (최소 금액 1,000원)");
        }
    }

    private void purchaseLotteries(int purchasePrice) {
        lotteries = new ArrayList<>();
        LotteryWheel lotteryWheel = new LotteryWheel();

        while (purchasePrice > 0) {
            Lotto lotto = new Lotto(lotteryWheel.generateLotteryNumbers());
            lotteries.add(lotto);
            purchasePrice -= LOTTO_PRICE_UNIT;
        }
        new OutputView().printLotteries(lotteries);
    }
}
