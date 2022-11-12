package lotto;

import lotto.controller.LottoMachineController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachineController.operateLottoMachine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
