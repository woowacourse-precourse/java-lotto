import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.create();
        lottoController.run();
    }
}
