package lotto.step;

import lotto.application.LottoApplicationContext;

public class InputWinnerNumber extends LottoStep {

    public InputWinnerNumber(LottoApplicationContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.inputWinnerNumber();
    }

    @Override
    public Step next() {
        return new Calculation(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
