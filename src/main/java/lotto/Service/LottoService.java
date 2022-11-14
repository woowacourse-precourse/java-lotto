package lotto.Service;

import lotto.Domain.LotteryTickets;
import lotto.Domain.Validator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoService {

    public static final int LOTTO_PRICE = 1000;

    public int getPurchaseAmount() {
        return getValidatePurchaseAmout();
    }

    public int getValidatePurchaseAmout() {
        int money = InputView.inputPurchaseAmount();
        return Validator.checkIsValidateAmount(money);
    }

    public LotteryTickets buyLottery(int purchaseAmount) {
        return new LotteryTickets(getLotteryPurchaseNum(purchaseAmount));
    }

    private int getLotteryPurchaseNum(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void showLottoPurchaseHistory(LotteryTickets lotteryTickets) {
        OutputView.showPurchasedLottos(lotteryTickets);
    }
}
