package lotto.logic;

import lotto.domain.Lotto;

public class LottoMachine {

    private static class LottoMachineHolder {
        private static final LottoMachine INSTANCE = new LottoMachine();
    }

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return LottoMachineHolder.INSTANCE;
    }

}
