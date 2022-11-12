package lotto.step;

import lotto.application.LottoApplicationContext;

public class ShowStatistics extends LottoStep {

    public ShowStatistics(LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.showStatistics();
    }

    @Override
    public Step next() {
        return new Exit(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
