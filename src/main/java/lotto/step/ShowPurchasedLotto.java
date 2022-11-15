package lotto.step;

import lotto.application.LottoApplicationContext;

public class ShowPurchasedLotto extends LottoStep {

    public ShowPurchasedLotto(final LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.showPurchasedLotto();
    }

    @Override
    public Step next() {
        return new InputWinnerNumber(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
