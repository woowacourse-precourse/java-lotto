package lotto.step;

import lotto.application.LottoApplicationContext;

public class Exit extends LottoStep {

    public Exit(LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        throw new RuntimeException();
    }

    @Override
    public Step next() {
        throw new RuntimeException();
    }

    @Override
    public boolean executable() {
        return false;
    }
}
