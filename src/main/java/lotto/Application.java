package lotto;

import lotto.controller.LottoSystem;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        try {
            lottoSystem.startProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
