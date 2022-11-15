package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            new LottoController().process();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}