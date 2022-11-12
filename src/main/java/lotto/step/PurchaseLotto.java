package lotto.step;

import lotto.application.LottoApplicationContext;

public class PurchaseLotto extends LottoStep {

    public PurchaseLotto(LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.purchaseLotto();
    }

    @Override
    public Step next() {
        return new ShowPurchasedLotto(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
