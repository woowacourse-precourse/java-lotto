package lotto;


import lotto.controller.DrawLottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DrawLottoController controller = new DrawLottoController();
        controller.startDrawLotto();
    }
}
