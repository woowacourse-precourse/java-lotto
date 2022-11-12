package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            new LottoController().LottoSimulationInit();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}