package lotto;

import lotto.controller.LottoMachineController;

public class Application {
    public static void main(String[] args) {
        LottoMachineController lmc = new LottoMachineController();
        lmc.runMainLottoMachine();
    }
}
