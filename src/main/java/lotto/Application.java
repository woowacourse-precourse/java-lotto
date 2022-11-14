package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.run();
    }
}
