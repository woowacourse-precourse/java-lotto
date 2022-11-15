package lotto;

import lotto.controller.LottoController;
import lotto.enums.OutputConstants;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(OutputConstants.ERROR_MESSAGE.getValue() + e.getMessage());
        }
    }
}
