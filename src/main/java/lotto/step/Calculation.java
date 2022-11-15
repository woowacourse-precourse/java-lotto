package lotto.step;

import lotto.application.LottoApplicationContext;

public class Calculation extends LottoStep {

    public Calculation(final LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.judgeWinning();
    }

    @Override
    public Step next() {
        return new ShowStatistics(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
