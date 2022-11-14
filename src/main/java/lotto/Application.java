package lotto;

import lotto.controller.LottoController;
import lotto.model.enumeration.Exception;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController();
        try {
            lottoController.init();
        } catch (IllegalArgumentException e) {
            System.out.println(Exception.PREFIX.getExceptionMessage() + e.getMessage());
        }
    }
}
