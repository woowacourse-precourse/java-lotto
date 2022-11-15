package lotto;

import lotto.controller.LottoController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }
}
