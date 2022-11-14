package lotto;

import controller.LottoController;
import utils.OutputUtils;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
        }
    }
}
